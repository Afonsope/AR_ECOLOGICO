package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.database.model.OrdemServicoEntity;
import com.example.demo.database.model.ServicoEntity;

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
public class ServicoRealizadoDto {
    private OrdemServicoEntity ordemServico;

    private ServicoEntity servico;

    private Integer qtd;

    private BigDecimal valor;

    private BigDecimal desconto;

    private String obs;
}
