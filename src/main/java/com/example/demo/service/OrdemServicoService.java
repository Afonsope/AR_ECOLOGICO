package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.database.model.ContratoEntity;
import com.example.demo.database.model.OrdemServicoEntity;
import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.database.model.PessoaJuridicaEntity;
import com.example.demo.database.model.PrestadorServicoEntity;
import com.example.demo.database.repository.IOrdemServicoRepository;
import com.example.demo.dto.OrdemServicoDto;

@Service 
public class OrdemServicoService {

    private final IOrdemServicoRepository repository;

    public OrdemServicoService(IOrdemServicoRepository repository){
        this.repository = repository;
    }
    
    public OrdemServicoEntity salvaOrdemServico(OrdemServicoDto dadosOrdemServico) {
        OrdemServicoEntity ordemServico = new OrdemServicoEntity();
        ordemServico.setTipoOs(dadosOrdemServico.getTipoOs());
        ordemServico.setValor(dadosOrdemServico.getValor());
        ordemServico.setObs(dadosOrdemServico.getObs());
        ordemServico.setDataAbertura(dadosOrdemServico.getDataAbertura());
        ordemServico.setStatus(dadosOrdemServico.getStatus());
        ordemServico.setDescricaoProblema(dadosOrdemServico.getDescricaoProblema());
        ordemServico.setDescricaoExecutado(dadosOrdemServico.getDescricaoExecutado());
        ordemServico.setDataExecucao(dadosOrdemServico.getDataExecucao());
        ordemServico.setPessoaFisicaCod(dadosOrdemServico.getPessoaFisicaCod());
        ordemServico.setPessoaJuridicaCod(dadosOrdemServico.getPessoaJuridicaCod());
        ordemServico.setContratoCod(dadosOrdemServico.getContratoCod());
        ordemServico.setPrestadorServicoCod(dadosOrdemServico.getPrestadorServicoCod());

        return repository.save(ordemServico);
    }

    public List<OrdemServicoEntity> listarTodasOrdensServico() {
        return repository.findAll();
    }

    public List<OrdemServicoEntity> verOrdemServico(Integer codOrdemServico) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        return List.of(ordemServicoExistente);
    }

    public OrdemServicoEntity atualizarOrdemServico(Integer codOrdemServico, OrdemServicoDto dadosOrdemServico) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        ordemServicoExistente.setTipoOs(dadosOrdemServico.getTipoOs());
        ordemServicoExistente.setValor(dadosOrdemServico.getValor());
        ordemServicoExistente.setObs(dadosOrdemServico.getObs());
        ordemServicoExistente.setDataAbertura(dadosOrdemServico.getDataAbertura());
        ordemServicoExistente.setStatus(dadosOrdemServico.getStatus());
        ordemServicoExistente.setDescricaoProblema(dadosOrdemServico.getDescricaoProblema());
        ordemServicoExistente.setDescricaoExecutado(dadosOrdemServico.getDescricaoExecutado());
        ordemServicoExistente.setDataExecucao(dadosOrdemServico.getDataExecucao());
        ordemServicoExistente.setPessoaFisicaCod(dadosOrdemServico.getPessoaFisicaCod());
        ordemServicoExistente.setPessoaJuridicaCod(dadosOrdemServico.getPessoaJuridicaCod());
        ordemServicoExistente.setContratoCod(dadosOrdemServico.getContratoCod());
        ordemServicoExistente.setPrestadorServicoCod(dadosOrdemServico.getPrestadorServicoCod());
        

        return repository.save(ordemServicoExistente);
    }

    public OrdemServicoEntity atualizaOrdemServicoParcial(Integer codOrdemServico, Map<String, Object> dados) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        if(dados.containsKey("tipoOs")) {
            ordemServicoExistente.setTipoOs((String) dados.get("tipoOs"));
        }
        if(dados.containsKey("valor")) {
            ordemServicoExistente.setValor((Double) dados.get("valor"));
        }
        if(dados.containsKey("obs")) {
            ordemServicoExistente.setObs((String) dados.get("obs"));
        }
        if(dados.containsKey("dataAbertura")) {
            ordemServicoExistente.setDataAbertura((LocalDate) dados.get("dataAbertura"));
        }
        if(dados.containsKey("status")) {
            ordemServicoExistente.setStatus((Integer) dados.get("status"));
        }
        if(dados.containsKey("descricaoProblema")) {
            ordemServicoExistente.setDescricaoProblema((String) dados.get("descricaoProblema"));
        }
        if(dados.containsKey("descricaoExecutado")) {
            ordemServicoExistente.setDescricaoExecutado((String) dados.get("descricaoExecutado"));
        }
        if(dados.containsKey("dataExecucao")) {
            ordemServicoExistente.setDataExecucao((LocalDate) dados.get("dataExecucao"));
        }
        if(dados.containsKey("pessoaFisica")) {
            ordemServicoExistente.setPessoaFisicaCod((PessoaFisicaEntity) dados.get("pessoaFisicaCod"));
        }
        if(dados.containsKey("pessoaJuridica")) {
            ordemServicoExistente.setPessoaJuridicaCod((PessoaJuridicaEntity) dados.get("pessoaJuridicaCod"));
        }
        if(dados.containsKey("contratoCod")) {
            ordemServicoExistente.setContratoCod((ContratoEntity) dados.get("contratoCod"));
        }
        if(dados.containsKey("prestadorServicoCod")) {
            ordemServicoExistente.setPrestadorServicoCod((PrestadorServicoEntity) dados.get("prestadorServicoCod"));
        }

        return repository.save(ordemServicoExistente);
    }

    public void deleta(Integer codOrdemServico) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        repository.delete(ordemServicoExistente);
    }
    
}
