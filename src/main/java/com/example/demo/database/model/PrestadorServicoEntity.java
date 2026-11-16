package com.example.demo.database.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor 
@Entity 
@Table(name = "PRESTADOR_SERVICOS")
@PrimaryKeyJoinColumn(name = "PRESTADOR_COD", referencedColumnName = "PESSOA_FISICA_COD")
@DynamicInsert
@ToString(exclude = {"ordensServico", "senha"})
public class PrestadorServicoEntity extends PessoaFisicaEntity {
    @Column(name = "PAGAMENTO", precision = 10, scale = 2, nullable = false)
    private BigDecimal pagamento;

    @Column(name = "ADMINISTRADOR", nullable = false)
    @ColumnDefault("1")
    private Boolean administrador = true;

    @JsonIgnore
    @Column(name = "SENHA", length = 255, nullable = false)
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "prestadorServicoCod")
    private List<OrdemServicoEntity> ordensServico = new ArrayList<>();

}
