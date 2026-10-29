package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.PessoaFisicaEntity;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisicaEntity, Integer> {

}
