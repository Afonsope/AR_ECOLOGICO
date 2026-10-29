package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.EquipamentoEntity;
import com.example.demo.Repository.EquipamentoRepository;

@Service 
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository){
        this.repository = repository;
    }
    
    public EquipamentoEntity salvaEquipamento(EquipamentoEntity equipamento) {
        return repository.save(equipamento);
    }

    public List<EquipamentoEntity> listarTodosEquipamentos() {
        return repository.findAll();
    }

    public List<EquipamentoEntity> verEquipamento(Integer codEquipamento) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        return List.of(equipamentoExistente);
    }

    public EquipamentoEntity atualizarEquipamento(Integer codEquipamento, EquipamentoEntity equipamento) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        equipamentoExistente.setBtus(equipamento.getBtus());
        equipamentoExistente.setModelo(equipamento.getModelo());
        equipamentoExistente.setMarca(equipamento.getMarca());
        equipamentoExistente.setObs(equipamento.getObs());

        return repository.save(equipamentoExistente);
    }

    public EquipamentoEntity atualizaEquipamentoParcial(Integer codEquipamento, Map<String, Object> dados) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
        
        if(dados.containsKey("btus")) {
            equipamentoExistente.setBtus((Integer) dados.get("btus"));
        }
        if(dados.containsKey("modelo")) {
            equipamentoExistente.setModelo((String) dados.get("modelo"));
        }
        if(dados.containsKey("marca")) {
            equipamentoExistente.setMarca((String) dados.get("marca"));
        }
        if(dados.containsKey("obs")) {
            equipamentoExistente.setObs((String) dados.get("obs"));
        }

        return repository.save(equipamentoExistente);
    }

    public void deleta(Integer codEquipamento) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        repository.delete(equipamentoExistente);
    }
}