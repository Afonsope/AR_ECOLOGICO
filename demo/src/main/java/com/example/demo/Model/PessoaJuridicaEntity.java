package com.example.demo.Model;

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
@Table(name = "PESSOAS_JURIDICAS")
public class PessoaJuridicaEntity extends PessoaEntity {
    @Column(name = "CNPJ", columnDefinition = "CHAR(14)", length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "RAZAO_SOCIAL", length = 100, nullable = false)
    private String razaoSocial;
}
