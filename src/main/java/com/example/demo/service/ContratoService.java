package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.database.model.ContratoEntity;
import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.database.model.PessoaJuridicaEntity;
import com.example.demo.database.repository.IContratoRepository;
import com.example.demo.dto.ContartoDto;

@Service 
public class ContratoService {

    private final IContratoRepository repository;

    public ContratoService(IContratoRepository repository){
        this.repository = repository;
    }
    
    public ContratoEntity salvaContrato(ContartoDto dadosContrato) {
        ContratoEntity contrato = new ContratoEntity();
        contrato.setDescricao(dadosContrato.getDescricao());
        contrato.setDataInicio(dadosContrato.getDataInicio());
        contrato.setDataFim(dadosContrato.getDataFim());
        contrato.setTipoContrato(dadosContrato.getTipoContrato());
        contrato.setObs(dadosContrato.getObs());
        contrato.setPessoaFisicaCod(dadosContrato.getPessoaFisicaCod());
        contrato.setPessoaJuridicaCod(dadosContrato.getPessoaJuridicaCod());

        return repository.save(contrato);
    }

    public List<ContratoEntity> listarTodosContratos() {
        return repository.findAll();
    }

    public List<ContratoEntity> verContrato(Integer codContrato) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        return List.of(contratoExistente);
    }

    public ContratoEntity atualizarContrato(Integer codContrato, ContartoDto dadosContrato) {
        ContratoEntity contratoExistente = repository.findById(codContrato).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));

        contratoExistente.setDescricao(dadosContrato.getDescricao());
        contratoExistente.setDataInicio(dadosContrato.getDataInicio());
        contratoExistente.setDataFim(dadosContrato.getDataFim());
        contratoExistente.setTipoContrato(dadosContrato.getTipoContrato());
        contratoExistente.setObs(dadosContrato.getObs());
        contratoExistente.setPessoaFisicaCod(dadosContrato.getPessoaFisicaCod());
        contratoExistente.setPessoaJuridicaCod(dadosContrato.getPessoaJuridicaCod());

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
