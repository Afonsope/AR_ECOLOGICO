package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.database.model.ContratoEquipamentoEntity;
import com.example.demo.database.model.ContratoEquipamentoId;
import com.example.demo.database.repository.IContratoEquipamentoRepository;
import com.example.demo.dto.ContratoEquipamentoDto;

@Service
public class ContratoEquipamentoService {

    private final IContratoEquipamentoRepository repository;

    public ContratoEquipamentoService(IContratoEquipamentoRepository repository) {
        this.repository = repository;
    }

    public ContratoEquipamentoEntity salvaContratoEquipamento(ContratoEquipamentoDto dadosContratoEquipamento) {
        ContratoEquipamentoEntity contratoEquipamento = new ContratoEquipamentoEntity(
                dadosContratoEquipamento.getContrato(),
                dadosContratoEquipamento.getEquipamento(),
                dadosContratoEquipamento.getQtd());

        return repository.save(contratoEquipamento);
    }

    public List<ContratoEquipamentoEntity> listarTodosContratosEquipamentos() {
        return repository.findAll();
    }

    public List<ContratoEquipamentoEntity> verContratoEquipamento(ContratoEquipamentoId id) {
        ContratoEquipamentoEntity contratoEquipamentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento do contrato não encontrado"));

        return List.of(contratoEquipamentoExistente);
    }

    public ContratoEquipamentoEntity atualizarContratoEquipamento(
            ContratoEquipamentoId id, ContratoEquipamentoDto dadosContratoEquipamento) {
        ContratoEquipamentoEntity contratoEquipamentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento do contrato não encontrado"));

        contratoEquipamentoExistente.setQtd(dadosContratoEquipamento.getQtd());

        return repository.save(contratoEquipamentoExistente);
    }

    public ContratoEquipamentoEntity atualizaContratoEquipamentoParcial(
            ContratoEquipamentoId id, Map<String, Object> dados) {
        ContratoEquipamentoEntity contratoEquipamentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento do contrato não encontrado"));

        if (dados.containsKey("qtd")) {
            contratoEquipamentoExistente.setQtd((Integer) dados.get("qtd"));
        }

        return repository.save(contratoEquipamentoExistente);
    }

    public void deletaContratoEquipamento(ContratoEquipamentoId id) {
        ContratoEquipamentoEntity contratoEquipamentoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento do contrato não encontrado"));

        repository.delete(contratoEquipamentoExistente);
    }
}
