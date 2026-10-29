package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.PrestadorServicoEntity;
import com.example.demo.Repository.PrestadorServicoRepository;

@Service 
public class PrestadorServicoService {

    private final PrestadorServicoRepository repository;

    public PrestadorServicoService(PrestadorServicoRepository repository){
        this.repository = repository;
    }
    
    public PrestadorServicoEntity salvaPessoa(PrestadorServicoEntity prestadorSevico) {
        return repository.save(prestadorSevico);
    }

    public List<PrestadorServicoEntity> listarTodosPrestadoresServicos() {
        return repository.findAll();
    }

    public List<PrestadorServicoEntity> verPrestadorServico(Integer codPessoa) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(prestadorServicoExistente);
    }

    public PrestadorServicoEntity atualizarPrestadorServico(Integer codPessoa, PrestadorServicoEntity prestadorServico) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        prestadorServicoExistente.setEndereco(prestadorServico.getEndereco());
        prestadorServicoExistente.setCep(prestadorServico.getCep());
        prestadorServicoExistente.setNumero(prestadorServico.getNumero());
        prestadorServicoExistente.setCidade(prestadorServico.getCidade());
        prestadorServicoExistente.setEstado(prestadorServico.getEstado());
        prestadorServicoExistente.setTelefone(prestadorServico.getTelefone());
        prestadorServicoExistente.setNome(prestadorServico.getNome());
        prestadorServicoExistente.setEmail(prestadorServico.getEmail());
        prestadorServicoExistente.setSalario(prestadorServico.getSalario());

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
            prestadorServicoExistente.setSalario((Double) dados.get("salario"));
        }

        return repository.save(prestadorServicoExistente);        
    }

    public void deletaPrestadorServico(Integer codPessoa) {
        PrestadorServicoEntity prestadorServicoExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        repository.delete(prestadorServicoExistente);
    }
    
}
