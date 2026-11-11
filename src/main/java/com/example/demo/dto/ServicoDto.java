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
public class ServicoDto {
    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Double valorServico;

    private String descricao;
}
