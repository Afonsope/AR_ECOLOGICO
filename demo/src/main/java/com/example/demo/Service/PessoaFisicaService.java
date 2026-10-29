package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import com.example.demo.Model.PessoaFisicaEntity;
import com.example.demo.Repository.PessoaFisicaRepository;

@Service 
public class PessoaFisicaService {

    private final PessoaFisicaRepository repository;

    public PessoaFisicaService(PessoaFisicaRepository repository){
        this.repository = repository;
    }
    
    public PessoaFisicaEntity salvaPessoa(PessoaFisicaEntity pessoaFisica) {
        return repository.save(pessoaFisica);
    }

    public List<PessoaFisicaEntity> listarTodasPessoasFisicas() {
        return repository.findAll();
    }

    public List<PessoaFisicaEntity> verPessoaFisica(Integer codPessoa) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(pessoaFisicaExistente);
    }

    public PessoaFisicaEntity atualizarPessoaFisica(Integer codPessoa, PessoaFisicaEntity pessoaFisica) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoaFisicaExistente.setEndereco(pessoaFisica.getEndereco());
        pessoaFisicaExistente.setCep(pessoaFisica.getCep());
        pessoaFisicaExistente.setNumero(pessoaFisica.getNumero());
        pessoaFisicaExistente.setCidade(pessoaFisica.getCidade());
        pessoaFisicaExistente.setEstado(pessoaFisica.getEstado());
        pessoaFisicaExistente.setTelefone(pessoaFisica.getTelefone());
        pessoaFisicaExistente.setNome(pessoaFisica.getNome());
        pessoaFisicaExistente.setEmail(pessoaFisica.getEmail());
        pessoaFisicaExistente.setCpf(pessoaFisica.getCpf());
        pessoaFisicaExistente.setRg(pessoaFisica.getRg());
        pessoaFisicaExistente.setDataNascimento(pessoaFisica.getDataNascimento());

        return repository.save(pessoaFisicaExistente);
    }

    public PessoaFisicaEntity atualizaPessoaFisicaParcial(Integer codPessoa, Map<String, Object> dados) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if(dados.containsKey("endereco")) {
            pessoaFisicaExistente.setEndereco((String) dados.get("endereco"));
        }
        if(dados.containsKey("cep")) {
            pessoaFisicaExistente.setCep((String) dados.get("cep"));
        }
        if(dados.containsKey("numero")) {
            pessoaFisicaExistente.setNumero((String) dados.get("numero"));
        }
        if(dados.containsKey("cidade")) {
            pessoaFisicaExistente.setCidade((String) dados.get("cidade"));
        }
        if(dados.containsKey("estado")) {
            pessoaFisicaExistente.setEstado((String) dados.get("estado"));
        }
        if(dados.containsKey("telefone")) {
            pessoaFisicaExistente.setTelefone((String) dados.get("telefone"));
        }
        if(dados.containsKey("nome")) {
            pessoaFisicaExistente.setNome((String) dados.get("nome"));
        }
        if(dados.containsKey("email")) {
            pessoaFisicaExistente.setEmail((String) dados.get("email"));
        }
        if(dados.containsKey("cpf")) {
            pessoaFisicaExistente.setCpf((String) dados.get("cpf"));
        }
        if(dados.containsKey("rg")) {
            pessoaFisicaExistente.setRg((String) dados.get("rg"));
        }
        if(dados.containsKey("dataNascimento")) {
            pessoaFisicaExistente.setDataNascimento((LocalDate) dados.get("dataNascimento"));
        }

        return repository.save(pessoaFisicaExistente);        
    }

    public void deletaPessoaFisica(Integer codPessoa) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        repository.delete(pessoaFisicaExistente);
    }
    
}
