package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.database.model.ServicoEntity;
import com.example.demo.database.repository.IServicoRepository;
import com.example.demo.dto.ServicoDto;

@Service 
public class ServicoService {

    private final IServicoRepository repository;

    public ServicoService(IServicoRepository repository){
        this.repository = repository;
    }
    
    public ServicoEntity salvaServico(ServicoDto dadosServico) {
        ServicoEntity servico = new ServicoEntity();
        servico.setDescricao(dadosServico.getDescricao());
        servico.setDataInicio(dadosServico.getDataInicio());
        servico.setDataFim(dadosServico.getDataFim());
        servico.setValorServico(dadosServico.getValorServico());

        return repository.save(servico);
    }

    public List<ServicoEntity> listarTodosServicos() {
        return repository.findAll();
    }

    public List<ServicoEntity> verServico(Integer codServico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return List.of(servicoExistente);
    }

    public ServicoEntity atualizarServico(Integer codServico, ServicoDto dadosServico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servicoExistente.setDescricao(dadosServico.getDescricao());
        servicoExistente.setDataInicio(dadosServico.getDataInicio());
        servicoExistente.setDataFim(dadosServico.getDataFim());
        servicoExistente.setValorServico(dadosServico.getValorServico());

        return repository.save(servicoExistente);
    }

    public ServicoEntity atualizaServicoParcial(Integer codServico, Map<String, Object> dados) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        if(dados.containsKey("descricao")) {
            servicoExistente.setDescricao((String) dados.get("descricao"));
        }
        if(dados.containsKey("dataInicio")) {
            servicoExistente.setDataInicio((LocalDate) dados.get("dataInicio"));
        }
        if(dados.containsKey("dataFim")) {
            servicoExistente.setDataFim((LocalDate) dados.get("dataFim"));
        }
        if(dados.containsKey("valorServico")) {
            servicoExistente.setValorServico((Double) dados.get("valorServico"));
        }

        return repository.save(servicoExistente);
    }

    public void deleta(Integer codServico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        repository.delete(servicoExistente);
    }
    
}
