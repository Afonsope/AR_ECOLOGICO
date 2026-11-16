package com.example.demo.dto;

import java.time.LocalDate;
import java.math.BigDecimal;

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

    private BigDecimal valorServico;

    private String descricao;
}
