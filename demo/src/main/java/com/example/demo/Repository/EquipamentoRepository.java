package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.EquipamentoEntity;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Integer> {

}
