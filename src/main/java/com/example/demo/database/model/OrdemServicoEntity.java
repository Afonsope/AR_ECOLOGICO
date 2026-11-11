package com.example.demo.database.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(
    name = "ORDENS_SERVICOS",
    check = {
        @CheckConstraint(
            name = "CK_OS_STATUS",
            constraint = "STATUS IN (1, 2, 3)"
        ),
        @CheckConstraint(
            name = "CK_OS_PESSOA",
            constraint = "(PESSOA_F_COD IS NOT NULL AND PESSOA_J_COD IS NULL) " +
                         "OR (PESSOA_F_COD IS NULL AND PESSOA_J_COD IS NOT NULL)"
        )
    }
)
@ToString 
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
    @JoinColumn(name = "PESSOA_F_COD")
    private PessoaFisicaEntity pessoaFisicaCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PESSOA_J_COD")
    private PessoaJuridicaEntity pessoaJuridicaCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRATO_COD")
    private ContratoEntity contratoCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESTADOR_SERVICO_COD")
    private PrestadorServicoEntity prestadorServicoCod;

     @OneToMany(mappedBy = "ordemServico")
    private List<ServicoRealizadoEntity> servicos = new ArrayList<>();
}
