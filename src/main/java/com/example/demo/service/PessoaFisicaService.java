package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.database.repository.IPessoaFisicaRepository;
import com.example.demo.dto.PessoaFisicaDto;

@Service 
public class PessoaFisicaService {

    private final IPessoaFisicaRepository repository;

    public PessoaFisicaService(IPessoaFisicaRepository repository){
        this.repository = repository;
    }
    
    public PessoaFisicaEntity salvaPessoa(PessoaFisicaDto dadosPessoa) {
        PessoaFisicaEntity pessoaFisica = new PessoaFisicaEntity();
        pessoaFisica.setEndereco(dadosPessoa.getEndereco());
        pessoaFisica.setCep(dadosPessoa.getCep());
        pessoaFisica.setNumero(dadosPessoa.getNumero());
        pessoaFisica.setCidade(dadosPessoa.getCidade());
        pessoaFisica.setEstado(dadosPessoa.getEstado());
        pessoaFisica.setTelefone(dadosPessoa.getTelefone());
        pessoaFisica.setNome(dadosPessoa.getNome());
        pessoaFisica.setEmail(dadosPessoa.getEmail());
        pessoaFisica.setCpf(dadosPessoa.getCpf());
        pessoaFisica.setRg(dadosPessoa.getRg());
        pessoaFisica.setDataNascimento(dadosPessoa.getDataNascimento());

        return repository.save(pessoaFisica);
    }

    public List<PessoaFisicaEntity> listarTodasPessoasFisicas() {
        return repository.findAll();
    }

    public List<PessoaFisicaEntity> verPessoaFisica(Integer codPessoa) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(pessoaFisicaExistente);
    }

    public PessoaFisicaEntity atualizarPessoaFisica(Integer codPessoa, PessoaFisicaDto dadosPessoa) {
        PessoaFisicaEntity pessoaFisicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoaFisicaExistente.setEndereco(dadosPessoa.getEndereco());
        pessoaFisicaExistente.setCep(dadosPessoa.getCep());
        pessoaFisicaExistente.setNumero(dadosPessoa.getNumero());
        pessoaFisicaExistente.setCidade(dadosPessoa.getCidade());
        pessoaFisicaExistente.setEstado(dadosPessoa.getEstado());
        pessoaFisicaExistente.setTelefone(dadosPessoa.getTelefone());
        pessoaFisicaExistente.setNome(dadosPessoa.getNome());
        pessoaFisicaExistente.setEmail(dadosPessoa.getEmail());
        pessoaFisicaExistente.setCpf(dadosPessoa.getCpf());
        pessoaFisicaExistente.setRg(dadosPessoa.getRg());
        pessoaFisicaExistente.setDataNascimento(dadosPessoa.getDataNascimento());

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
