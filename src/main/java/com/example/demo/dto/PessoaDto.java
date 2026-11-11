package com.example.demo.dto;

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
public class PessoaDto {
    private String endereco;

    private String cep;

    private String numero;

    private String cidade;

    private String estado;

    private String telefone;

    private String nome;

    private String email;
}
