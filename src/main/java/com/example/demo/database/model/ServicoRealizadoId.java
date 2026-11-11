package com.example.demo.database.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ServicoRealizadoId implements Serializable {

    @Column(name = "OS_COD")
    private Integer osCod;

    @Column(name = "SERVICO_COD")
    private Integer servicoCod;
}