package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.model.ServicoEntity;

@Repository
public interface IServicoRepository extends JpaRepository<ServicoEntity, Integer> {

}
