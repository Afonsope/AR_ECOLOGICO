package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.database.model.PrestadorServicoEntity;
import com.example.demo.database.repository.IPrestadorServicoRepository;
import com.example.demo.dto.PrestadorServicoDto;

@Service 
public class PrestadorServicoService {

    private final IPrestadorServicoRepository repository;

    public PrestadorServicoService(IPrestadorServicoRepository repository){
        this.repository = repository;
    }
    
    public PrestadorServicoEntity salvaPessoa(PrestadorServicoDto dadosPrestador) {
        PrestadorServicoEntity prestadorSevico = new PrestadorServicoEntity();
        prestadorSevico.setEndereco(dadosPrestador.getEndereco());
        prestadorSevico.setCep(dadosPrestador.getCep());
        prestadorSevico.setNumero(dadosPrestador.getNumero());
        prestadorSevico.setCidade(dadosPrestador.getCidade());
        prestadorSevico.setEstado(dadosPrestador.getEstado());
        prestadorSevico.setTelefone(dadosPrestador.getTelefone());
        prestadorSevico.setNome(dadosPrestador.getNome());
        prestadorSevico.setEmail(dadosPrestador.getEmail());
        prestadorSevico.setPagamento(dadosPrestador.getSalario());

        return repository.save(prestadorSevico);
    }

    public List<PrestadorServicoEntity> listarTodosPrestadoresServicos() {
        return repository.findAll();
    }

    public List<PrestadorServicoEntity> verPrestadorServico(Integer codPessoa) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(prestadorServicoExistente);
    }

    public PrestadorServicoEntity atualizarPrestadorServico(Integer codPessoa, PrestadorServicoDto dadosPrestador) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        prestadorServicoExistente.setEndereco(dadosPrestador.getEndereco());
        prestadorServicoExistente.setCep(dadosPrestador.getCep());
        prestadorServicoExistente.setNumero(dadosPrestador.getNumero());
        prestadorServicoExistente.setCidade(dadosPrestador.getCidade());
        prestadorServicoExistente.setEstado(dadosPrestador.getEstado());
        prestadorServicoExistente.setTelefone(dadosPrestador.getTelefone());
        prestadorServicoExistente.setNome(dadosPrestador.getNome());
        prestadorServicoExistente.setEmail(dadosPrestador.getEmail());
        prestadorServicoExistente.setPagamento(dadosPrestador.getSalario());

        return repository.save(prestadorServicoExistente);
    }

    public PrestadorServicoEntity atualizaPrestadorServicoParcial(Integer codPessoa, Map<String, Object> dados) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if(dados.containsKey("endereco")) {
            prestadorServicoExistente.setEndereco((String) dados.get("endereco"));
        }
        if(dados.containsKey("cep")) {
            prestadorServicoExistente.setCep((String) dados.get("cep"));
        }
        if(dados.containsKey("numero")) {
            prestadorServicoExistente.setNumero((String) dados.get("numero"));
        }
        if(dados.containsKey("cidade")) {
            prestadorServicoExistente.setCidade((String) dados.get("cidade"));
        }
        if(dados.containsKey("estado")) {
            prestadorServicoExistente.setEstado((String) dados.get("estado"));
        }
        if(dados.containsKey("telefone")) {
            prestadorServicoExistente.setTelefone((String) dados.get("telefone"));
        }
        if(dados.containsKey("nome")) {
            prestadorServicoExistente.setNome((String) dados.get("nome"));
        }
        if(dados.containsKey("email")) {
            prestadorServicoExistente.setEmail((String) dados.get("email"));
        }
        if(dados.containsKey("salario")) {
            prestadorServicoExistente.setPagamento((Double) dados.get("pagamento"));
        }

        return repository.save(prestadorServicoExistente);        
    }

    public void deletaPrestadorServico(Integer codPessoa) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        repository.delete(prestadorServicoExistente);
    }
    
}
