package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "CONTRATOS")
@Check(constraints = """
    (PESSOA_F_COD IS NOT NULL AND PESSOA_J_COD IS NULL) OR
    (PESSOA_F_COD IS NULL AND PESSOA_J_COD IS NOT NULL)
""")
public class ContratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CONTRATO")
    private Integer codContrato;

    @Column(name = "DESCRICAO", length = 500, nullable = false)
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDate dataFim;

    @Column(name = "TIPO_CONTRATO", length = 50, nullable = false)
    private String tipoContrato;

    @Column(name = "OBS", length = 500)
    private String obs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PESSOA_FISICA")
    private PessoaFisicaEntity pessoaFisicaCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PESSOA_JURIDICA")
    private PessoaJuridicaEntity pessoaJuridicaCod;
}
