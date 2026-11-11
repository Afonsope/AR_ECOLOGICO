package com.example.demo.database.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@ToString  
public class PessoaJuridicaEntity extends PessoaEntity {
    @Column(name = "CNPJ", columnDefinition = "CHAR(14)", length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "RAZAO_SOCIAL", length = 100, nullable = false)
    private String razaoSocial;

    @OneToMany(mappedBy = "pessoaJuridica")
    private List<ContratoEntity> contratos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoaJuridica")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
