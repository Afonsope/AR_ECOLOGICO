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
@Table(name = "ORDENS_SERVICOS")
@Check(constraints = """
    (PESSOA_F_COD IS NOT NULL AND PESSOA_J_COD IS NULL) OR
    (PESSOA_F_COD IS NULL AND PESSOA_J_COD IS NOT NULL)
""")
public class OrdemServicoEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_OS")
    private Integer codOs;

    @Column(name = "TIPO_OS", length = 50, nullable = false)
    private String tipoOs;

    @Column(name = "VALOR", precision = 10, scale = 2)
    private Double valor;

    @Column(name = "OBS", length = 500)
    private String obs;

    @Column(name = "DATA_ABERTURA", nullable = false)
    private LocalDate dataAbertura;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @Column(name = "DESCRICAO_PROBLEMA", length = 500, nullable = false)
    private String descricaoProblema;

    @Column(name = "DESCRICAO_EXECUTADO", length = 500)
    private String descricaoExecutado;

    @Column(name = "DATA_EXECUCAO")
    private LocalDate dataExecucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PESSOA_FISICA")
    @Column(name = "PESSOA_F_COD")
    private PessoaFisicaEntity pessoaFisicaCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PESSOA_JURIDICA")
    @Column(name = "PESSOA_J_COD")
    private PessoaJuridicaEntity pessoaJuridicaCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTRATO")
    @Column(name = "CONTRATO_COD")
    private ContratoEntity contratoCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESTADOR_COD")
    @Column(name = "PRESTADOR_SERVICO_COD")
    private PrestadorServicoEntity prestadorServicoCod;
}
