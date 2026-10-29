package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.Model.ContratoEntity;
import com.example.demo.Model.PessoaFisicaEntity;
import com.example.demo.Model.PessoaJuridicaEntity;
import com.example.demo.Repository.ContratoRepository;

@Service 
public class ContratoService {

    private final ContratoRepository repository;

    public ContratoService(ContratoRepository repository){
        this.repository = repository;
    }
    
    public ContratoEntity salvaContrato(ContratoEntity contrato) {
        return repository.save(contrato);
    }

    public List<ContratoEntity> listarTodosContratos() {
        return repository.findAll();
    }

    public List<ContratoEntity> verContrato(Integer codContrato) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        return List.of(contratoExistente);
    }

    public ContratoEntity atualizarContrato(Integer codContrato, ContratoEntity contrato) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        contratoExistente.setDescricao(contrato.getDescricao());
        contratoExistente.setDataInicio(contrato.getDataInicio());
        contratoExistente.setDataFim(contrato.getDataFim());
        contratoExistente.setTipoContrato(contrato.getTipoContrato());
        contratoExistente.setObs(contrato.getObs());
        contratoExistente.setPessoaFisicaCod(contrato.getPessoaFisicaCod());
        contratoExistente.setPessoaJuridicaCod(contrato.getPessoaJuridicaCod());

        return repository.save(contratoExistente);
    }

    public ContratoEntity atualizaContratoParcial(Integer codContrato, Map<String, Object> dados) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        if(dados.containsKey("descricao")) {
            contratoExistente.setDescricao((String) dados.get("descricao"));
        }
        if(dados.containsKey("dataInicio")) {
            contratoExistente.setDataInicio((LocalDate) dados.get("dataInicio"));
        }
        if(dados.containsKey("dataFim")) {
            contratoExistente.setDataFim((LocalDate) dados.get("dataFim"));
        }
        if(dados.containsKey("tipoContrato")) {
            contratoExistente.setTipoContrato((String) dados.get("tipoContrato"));
        }
        if(dados.containsKey("obs")) {
            contratoExistente.setObs((String) dados.get("obs"));
        }
        if(dados.containsKey("pessoaFisica")) {
            contratoExistente.setPessoaFisicaCod((PessoaFisicaEntity) dados.get("pessoaFisicaCod"));
        }
        if(dados.containsKey("pessoaJuridica")) {
            contratoExistente.setPessoaJuridicaCod((PessoaJuridicaEntity) dados.get("pessoaJuridicaCod"));
        }

        return repository.save(contratoExistente);
    }

    public void deleta(Integer codContrato) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        repository.delete(contratoExistente);
    }
    
}
