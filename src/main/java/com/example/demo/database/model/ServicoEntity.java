package com.example.demo.database.model;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter  
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "SERVICOS")
@ToString(exclude = "ordensServico")
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
    private BigDecimal valorServico;

    @Column(name = "DESCRICAO", length = 500, nullable = false)
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<ServicoRealizadoEntity> ordensServico = new ArrayList<>();
}
