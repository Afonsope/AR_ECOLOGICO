package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.model.ContratoEquipamentoEntity;
import com.example.demo.database.model.ContratoEquipamentoId;

@Repository
public interface IContratoEquipamentoRepository
        extends JpaRepository<ContratoEquipamentoEntity, ContratoEquipamentoId> {

}
