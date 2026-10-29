package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.PrestadorServicoEntity;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServicoEntity, Integer> {

}
