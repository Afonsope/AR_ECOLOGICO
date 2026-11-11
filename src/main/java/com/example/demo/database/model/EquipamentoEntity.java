package com.example.demo.database.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "EQUIPAMENTOS")
@ToString 
public class EquipamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EQUIPAMENTO")
    private Integer codEquipamento;

    @Column(name = "BTUS", nullable = false)
    private Integer btus;

    @Column(name = "MODELO", length = 100, nullable = false)
    private String modelo;

    @Column(name = "MARCA", length = 50, nullable = false)
    private String marca;

    @Column(name = "OBS", length = 300)
    private String obs;

    @OneToMany(mappedBy = "equipamento")
    private List<ContratoEquipamentoEntity> contratos = new ArrayList<>();
}
