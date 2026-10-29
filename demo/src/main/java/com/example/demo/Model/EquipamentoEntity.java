package com.example.demo.Model;

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
@Table(name = "EQUIPAMENTOS")
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
}
