package com.example.demo.database.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContratoEquipamentoId implements Serializable {

    @Column(name = "CONTRATO_COD")
    private Integer contratoCod;

    @Column(name = "EQUIPAMENTO_COD")
    private Integer equipamentoCod;
}