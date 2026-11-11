package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.database.model.ContratoEntity;
import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.database.model.PessoaJuridicaEntity;
import com.example.demo.database.model.PrestadorServicoEntity;

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
public class OrdemServicoDto {
    private String tipoOs;

    private Double valor;

    private String obs;

    private LocalDate dataAbertura;

    private Integer status;

    private String descricaoProblema;

    private String descricaoExecutado;

    private LocalDate dataExecucao;

    private PessoaFisicaEntity pessoaFisicaCod;
    
    private PessoaJuridicaEntity pessoaJuridicaCod;

    private ContratoEntity contratoCod;

    private PrestadorServicoEntity prestadorServicoCod;
}
