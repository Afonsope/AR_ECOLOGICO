package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "PESSOAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PESSOA")
    private Integer codPessoa;

    @Column(name = "ENDERECO", length = 50, nullable = false)
    private String endereco;

    @Column(name = "CEP", columnDefinition = "CHAR(8)", length = 8, nullable = false)
    private String cep;

    @Column(name = "NUMERO", length = 10, nullable = false)
    private String numero;

    @Column(name = "CIDADE", length = 50, nullable = false)
    private String cidade;

    @Column(name = "ESTADO", columnDefinition = "CHAR(2)", length = 2, nullable = false)
    private String estado;

    @Column(name = "TELEFONE", length = 15, nullable = false)
    private String telefone;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 150)
    private String email;
}
