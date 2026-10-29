package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.Model.ServicoEntity;
import com.example.demo.Repository.ServicoRepository;

@Service 
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository){
        this.repository = repository;
    }
    
    public ServicoEntity salvaServico(ServicoEntity servico) {
        return repository.save(servico);
    }

    public List<ServicoEntity> listarTodosServicos() {
        return repository.findAll();
    }

    public List<ServicoEntity> verServico(Integer codServico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return List.of(servicoExistente);
    }

    public ServicoEntity atualizarServico(Integer codServico, ServicoEntity servico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servicoExistente.setDescricao(servico.getDescricao());
        servicoExistente.setDataInicio(servico.getDataInicio());
        servicoExistente.setDataFim(servico.getDataFim());
        servicoExistente.setValorServico(servico.getValorServico());
        servicoExistente.setObs(servico.getObs());

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
        if(dados.containsKey("obs")) {
            servicoExistente.setObs((String) dados.get("obs"));
        }

        return repository.save(servicoExistente);
    }

    public void deleta(Integer codServico) {
        ServicoEntity servicoExistente = repository.findById(codServico).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        repository.delete(servicoExistente);
    }
    
}
