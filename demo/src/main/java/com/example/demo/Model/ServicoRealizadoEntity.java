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
import org.springframework.boot.context.properties.bind.Name;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "SERVICOS_REALIZADOS")
public class ServicoRealizadoEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_OS")
    @Column(name = "OS_COD", nullable = false)
    private OrdemServicoEntity osCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_SERVICO")
    @Column(name = "SERVICO_COD", nullable = false)
    private ServicoEntity servicoCod;
}
