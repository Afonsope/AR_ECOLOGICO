package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.model.PessoaEntity;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaEntity, Integer> {

}
