package com.example.demo.database.model;

import java.time.LocalDate;
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
@Table(name = "PESSOAS_FISICAS")
@ToString 
public class PessoaFisicaEntity extends PessoaEntity {
    @Column(name = "CPF", columnDefinition = "CHAR(11)", length = 11, nullable = false)
    private String cpf;

    @Column(name = "RG", columnDefinition = "CHAR(15)", length = 15)
    private String rg;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoaFisica")
    private List<ContratoEntity> contratos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoaFisica")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
