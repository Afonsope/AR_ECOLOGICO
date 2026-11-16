package com.example.demo.database.model;

import java.time.LocalDate;
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
@Table(name = "PESSOAS_FISICAS")
@PrimaryKeyJoinColumn(name = "PESSOA_FISICA_COD", referencedColumnName = "COD_PESSOA")
@ToString(exclude = {"contratos", "ordensServico"})
public class PessoaFisicaEntity extends PessoaEntity {
    @Column(name = "CPF", columnDefinition = "CHAR(11)", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "RG", columnDefinition = "CHAR(15)", length = 15)
    private String rg;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaFisicaCod")
    private List<ContratoEntity> contratos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaFisicaCod")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
