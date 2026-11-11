package com.example.demo.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CONTRATOS_EQUIPAMENTOS")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"contrato", "equipamento"})
public class ContratoEquipamentoEntity {

    @EmbeddedId
    private ContratoEquipamentoId id = new ContratoEquipamentoId();

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

    public ContratoEquipamentoEntity(ContratoEntity contrato, EquipamentoEntity equipamento, Integer qtd) {
        this.contrato = contrato;
        this.equipamento = equipamento;
        this.qtd = qtd;
    }
}