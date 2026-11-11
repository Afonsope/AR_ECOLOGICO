package com.example.demo.dto;

import com.example.demo.database.model.ContratoEntity;
import com.example.demo.database.model.EquipamentoEntity;

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
public class ContratoEquipamentoDto {
    private ContratoEntity contrato;

    private EquipamentoEntity equipamento;

    private Integer qtd;
}
