package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.database.model.PessoaJuridicaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
public class ContartoDto {
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String tipoContrato;

    private String obs;

    private PessoaFisicaEntity pessoaFisicaCod;

    private PessoaJuridicaEntity pessoaJuridicaCod;
}
