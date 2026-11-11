package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.model.PessoaFisicaEntity;

@Repository
public interface IPessoaFisicaRepository extends JpaRepository<PessoaFisicaEntity, Integer> {

}
