package com.example.demo.database.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "PESSOAS_JURIDICAS")
@PrimaryKeyJoinColumn(name = "PESSOA_JURIDICA_COD", referencedColumnName = "COD_PESSOA")
@ToString(exclude = {"contratos", "ordensServico"})
public class PessoaJuridicaEntity extends PessoaEntity {
    @Column(name = "CNPJ", columnDefinition = "CHAR(14)", length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "RAZAO_SOCIAL", length = 100, nullable = false)
    private String razaoSocial;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaJuridicaCod")
    private List<ContratoEntity> contratos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaJuridicaCod")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
