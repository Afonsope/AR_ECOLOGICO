package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.model.ServicoRealizadoEntity;
import com.example.demo.database.model.ServicoRealizadoId;

@Repository
public interface IServicoRealizadoRepository extends JpaRepository<ServicoRealizadoEntity, ServicoRealizadoId> {

}
