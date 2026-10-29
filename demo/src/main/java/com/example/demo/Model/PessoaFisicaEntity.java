package com.example.demo.Model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "PESSOAS_FISICAS")
public class PessoaFisicaEntity extends PessoaEntity {
    @Column(name = "CPF", columnDefinition = "CHAR(11)", length = 11, nullable = false)
    private String cpf;

    @Column(name = "RG", columnDefinition = "CHAR(15)", length = 15)
    private String rg;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;
}
