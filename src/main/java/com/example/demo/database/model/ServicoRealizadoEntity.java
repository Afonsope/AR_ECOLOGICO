package com.example.demo.database.model;

import java.math.BigDecimal;

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
@Table(name = "SERVICOS_REALIZADOS")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"ordemServico", "servico"})
public class ServicoRealizadoEntity {

    @EmbeddedId
    private ServicoRealizadoId id = new ServicoRealizadoId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("osCod")
    @JoinColumn(name = "OS_COD")
    private OrdemServicoEntity ordemServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("servicoCod")
    @JoinColumn(name = "SERVICO_COD")
    private ServicoEntity servico;

    @Column(name = "QTD", nullable = false)
    private Integer qtd;

    @Column(name = "VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "DESCONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;

    @Column(name = "OBS", length = 500)
    private String obs;

    public ServicoRealizadoEntity(OrdemServicoEntity ordemServico, ServicoEntity servico,
                                  Integer qtd, BigDecimal valor, BigDecimal desconto, String obs) {
        this.ordemServico = ordemServico;
        this.servico = servico;
        this.qtd = qtd;
        this.valor = valor;
        this.desconto = desconto;
        this.obs = obs;
    }
}