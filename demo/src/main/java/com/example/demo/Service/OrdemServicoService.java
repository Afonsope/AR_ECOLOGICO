package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


import com.example.demo.Model.ContratoEntity;
import com.example.demo.Model.PessoaFisicaEntity;
import com.example.demo.Model.PessoaJuridicaEntity;
import com.example.demo.Repository.OrdemServicoRepository;
import com.example.demo.Model.OrdemServicoEntity;
import com.example.demo.Model.PrestadorServicoEntity;

@Service 
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    public OrdemServicoService(OrdemServicoRepository repository){
        this.repository = repository;
    }
    
    public OrdemServicoEntity salvaOrdemServico(OrdemServicoEntity ordemServico) {
        return repository.save(ordemServico);
    }

    public List<OrdemServicoEntity> listarTodasOrdensServico() {
        return repository.findAll();
    }

    public List<OrdemServicoEntity> verOrdemServico(Integer codOrdemServico) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        return List.of(ordemServicoExistente);
    }

    public OrdemServicoEntity atualizarOrdemServico(Integer codOrdemServico, OrdemServicoEntity ordemServico) {
        OrdemServicoEntity ordemServicoExistente = repository.findById(codOrdemServico).orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));

        ordemServicoExistente.setTipoOs(ordemServico.getTipoOs());
        ordemServicoExistente.setValor(ordemServico.getValor());
        ordemServicoExistente.setObs(ordemServico.getObs());
        ordemServicoExistente.setDataAbertura(ordemServico.getDataAbertura());
        ordemServicoExistente.setStatus(ordemServico.getStatus());
        ordemServicoExistente.setDescricaoProblema(ordemServico.getDescricaoProblema());
        ordemServicoExistente.setDescricaoExecutado(ordemServico.getDescricaoExecutado());
        ordemServicoExistente.setDataExecucao(ordemServico.getDataExecucao());
        ordemServicoExistente.setPessoaFisicaCod(ordemServico.getPessoaFisicaCod());
        ordemServicoExistente.setPessoaJuridicaCod(ordemServico.getPessoaJuridicaCod());
        ordemServicoExistente.setContratoCod(ordemServico.getContratoCod());
        ordemServicoExistente.setPrestadorServicoCod(ordemServico.getPrestadorServicoCod());
        

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
