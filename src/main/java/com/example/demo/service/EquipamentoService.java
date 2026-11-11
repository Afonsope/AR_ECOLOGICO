package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.database.model.EquipamentoEntity;
import com.example.demo.database.repository.IEquipamentoRepository;
import com.example.demo.dto.EquipamentoDto;

@Service 
public class EquipamentoService {

    private final IEquipamentoRepository repository;

    public EquipamentoService(IEquipamentoRepository repository){
        this.repository = repository;
    }
    
    public EquipamentoEntity salvaEquipamento(EquipamentoDto dadosEquipamento) {
        EquipamentoEntity equipamento = new EquipamentoEntity();
        equipamento.setBtus(dadosEquipamento.getBtus());
        equipamento.setModelo(dadosEquipamento.getModelo());
        equipamento.setMarca(dadosEquipamento.getMarca());
        equipamento.setObs(dadosEquipamento.getObs());

        return repository.save(equipamento);
    }

    public List<EquipamentoEntity> listarTodosEquipamentos() {
        return repository.findAll();
    }

    public List<EquipamentoEntity> verEquipamento(Integer codEquipamento) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        return List.of(equipamentoExistente);
    }

    public EquipamentoEntity atualizarEquipamento(Integer codEquipamento, EquipamentoDto dadosEquipamento) {
        EquipamentoEntity equipamentoExistente = repository.findById(codEquipamento).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        equipamentoExistente.setBtus(dadosEquipamento.getBtus());
        equipamentoExistente.setModelo(dadosEquipamento.getModelo());
        equipamentoExistente.setMarca(dadosEquipamento.getMarca());
        equipamentoExistente.setObs(dadosEquipamento.getObs());

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