package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.database.model.ServicoRealizadoEntity;
import com.example.demo.database.model.ServicoRealizadoId;
import com.example.demo.database.repository.IServicoRealizadoRepository;
import com.example.demo.dto.ServicoRealizadoDto;

@Service
public class ServicoRealizadoService {

    private final IServicoRealizadoRepository repository;

    public ServicoRealizadoService(IServicoRealizadoRepository repository) {
        this.repository = repository;
    }

    public ServicoRealizadoEntity salvaServicoRealizado(ServicoRealizadoDto dadosServicoRealizado) {
        ServicoRealizadoEntity servicoRealizado = new ServicoRealizadoEntity(
                dadosServicoRealizado.getOrdemServico(),
                dadosServicoRealizado.getServico(),
                dadosServicoRealizado.getQtd(),
                dadosServicoRealizado.getValor(),
                dadosServicoRealizado.getDesconto(),
                dadosServicoRealizado.getObs());

        return repository.save(servicoRealizado);
    }

    public List<ServicoRealizadoEntity> listarTodosServicosRealizados() {
        return repository.findAll();
    }

    public List<ServicoRealizadoEntity> verServicoRealizado(ServicoRealizadoId id) {
        ServicoRealizadoEntity servicoRealizadoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço realizado não encontrado"));

        return List.of(servicoRealizadoExistente);
    }

    public ServicoRealizadoEntity atualizarServicoRealizado(
            ServicoRealizadoId id, ServicoRealizadoDto dadosServicoRealizado) {
        ServicoRealizadoEntity servicoRealizadoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço realizado não encontrado"));

        servicoRealizadoExistente.setQtd(dadosServicoRealizado.getQtd());
        servicoRealizadoExistente.setValor(dadosServicoRealizado.getValor());
        servicoRealizadoExistente.setDesconto(dadosServicoRealizado.getDesconto());
        servicoRealizadoExistente.setObs(dadosServicoRealizado.getObs());

        return repository.save(servicoRealizadoExistente);
    }

    public ServicoRealizadoEntity atualizaServicoRealizadoParcial(
            ServicoRealizadoId id, Map<String, Object> dados) {
        ServicoRealizadoEntity servicoRealizadoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço realizado não encontrado"));

        if (dados.containsKey("qtd")) {
            servicoRealizadoExistente.setQtd((Integer) dados.get("qtd"));
        }
        if (dados.containsKey("valor")) {
            servicoRealizadoExistente.setValor((BigDecimal) dados.get("valor"));
        }
        if (dados.containsKey("desconto")) {
            servicoRealizadoExistente.setDesconto((BigDecimal) dados.get("desconto"));
        }
        if (dados.containsKey("obs")) {
            servicoRealizadoExistente.setObs((String) dados.get("obs"));
        }

        return repository.save(servicoRealizadoExistente);
    }

    public void deletaServicoRealizado(ServicoRealizadoId id) {
        ServicoRealizadoEntity servicoRealizadoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço realizado não encontrado"));

        repository.delete(servicoRealizadoExistente);
    }
}
