package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "CONTRATOS_EQUIPAMENTOS")
public class ContratoEquipamentoEntity {

    @EmbeddedId
    // private ContratoEquipamentoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("contratoCod")
    @JoinColumn(name = "CONTRATO_COD")
    private ContratoEntity contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("equipamentoCod")
    @JoinColumn(name = "EQUIPAMENTO_COD")
    private EquipamentoEntity equipamento;

    @Column(name = "QTD", nullable = false)
    private Integer qtd;
}