package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "SERVICOS")
public class ServicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_SERVICO")
    private Integer codServico;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDate dataFim;

    @Column(name = "VALOR_SERVICO", precision = 10, scale = 2, nullable = false)
    private Double valorServico;

    @Column(name = "DESCRICAO", length = 500, nullable = false)
    private String descricao;

    @Column(name = "OBS", length = 500, nullable = true)
    private String obs;
}
