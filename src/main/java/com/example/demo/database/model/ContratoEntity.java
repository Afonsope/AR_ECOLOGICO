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
    name = "CONTRATOS",
    check = {
        @CheckConstraint(
            name = "CK_PESSOA_FISICA_OU_JURIDICA",
            constraint = "(COD_PESSOA_FISICA IS NOT NULL AND COD_PESSOA_JURIDICA IS NULL) " +
                         "OR (COD_PESSOA_FISICA IS NULL AND COD_PESSOA_JURIDICA IS NOT NULL)"
        )
    }
)
@ToString 
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

     @OneToMany(mappedBy = "contrato")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

    @OneToMany(mappedBy = "contrato")
    private List<ContratoEquipamentoEntity> equipamentos = new ArrayList<>();
}
