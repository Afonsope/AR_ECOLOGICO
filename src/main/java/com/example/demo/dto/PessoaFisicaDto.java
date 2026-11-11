package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@ToString 
@Builder 
public class PessoaFisicaDto {
    private String endereco;

    private String cep;

    private String numero;

    private String cidade;

    private String estado;

    private String telefone;

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private LocalDate dataNascimento;
}
