package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.example.demo.database.model.PessoaJuridicaEntity;
import com.example.demo.database.repository.IPessoaJuridicaRepository;
import com.example.demo.dto.PessoaJuridicaDto;

@Service 
public class PessoaJuridicaService {

    private final IPessoaJuridicaRepository repository;

    public PessoaJuridicaService(IPessoaJuridicaRepository repository){
        this.repository = repository;
    }
    
    public PessoaJuridicaEntity salvaPessoa(PessoaJuridicaDto dadosPessoa) {
        PessoaJuridicaEntity pessoaJuridica = new PessoaJuridicaEntity();
        pessoaJuridica.setEndereco(dadosPessoa.getEndereco());
        pessoaJuridica.setCep(dadosPessoa.getCep());
        pessoaJuridica.setNumero(dadosPessoa.getNumero());
        pessoaJuridica.setCidade(dadosPessoa.getCidade());
        pessoaJuridica.setEstado(dadosPessoa.getEstado());
        pessoaJuridica.setTelefone(dadosPessoa.getTelefone());
        pessoaJuridica.setNome(dadosPessoa.getNome());
        pessoaJuridica.setEmail(dadosPessoa.getEmail());
        pessoaJuridica.setCnpj(dadosPessoa.getCnpj());
        pessoaJuridica.setRazaoSocial(dadosPessoa.getRazaoSocial());

        return repository.save(pessoaJuridica);
    }

    public List<PessoaJuridicaEntity> listarTodasPessoasFisicas() {
        return repository.findAll();
    }

    public List<PessoaJuridicaEntity> verPessoaJuridica(Integer codPessoa) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(pessoaJuridicaExistente);
    }

    public PessoaJuridicaEntity atualizarPessoaJuridica(Integer codPessoa, PessoaJuridicaDto dadosPessoa) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoaJuridicaExistente.setEndereco(dadosPessoa.getEndereco());
        pessoaJuridicaExistente.setCep(dadosPessoa.getCep());
        pessoaJuridicaExistente.setNumero(dadosPessoa.getNumero());
        pessoaJuridicaExistente.setCidade(dadosPessoa.getCidade());
        pessoaJuridicaExistente.setEstado(dadosPessoa.getEstado());
        pessoaJuridicaExistente.setTelefone(dadosPessoa.getTelefone());
        pessoaJuridicaExistente.setNome(dadosPessoa.getNome());
        pessoaJuridicaExistente.setEmail(dadosPessoa.getEmail());
        pessoaJuridicaExistente.setCnpj(dadosPessoa.getCnpj());
        pessoaJuridicaExistente.setRazaoSocial(dadosPessoa.getRazaoSocial());

        return repository.save(pessoaJuridicaExistente);
    }

    public PessoaJuridicaEntity atualizaPessoaJuridicaParcial(Integer codPessoa, Map<String, Object> dados) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if(dados.containsKey("endereco")) {
            pessoaJuridicaExistente.setEndereco((String) dados.get("endereco"));
        }
        if(dados.containsKey("cep")) {
            pessoaJuridicaExistente.setCep((String) dados.get("cep"));
        }
        if(dados.containsKey("numero")) {
            pessoaJuridicaExistente.setNumero((String) dados.get("numero"));
        }
        if(dados.containsKey("cidade")) {
            pessoaJuridicaExistente.setCidade((String) dados.get("cidade"));
        }
        if(dados.containsKey("estado")) {
            pessoaJuridicaExistente.setEstado((String) dados.get("estado"));
        }
        if(dados.containsKey("telefone")) {
            pessoaJuridicaExistente.setTelefone((String) dados.get("telefone"));
        }
        if(dados.containsKey("nome")) {
            pessoaJuridicaExistente.setNome((String) dados.get("nome"));
        }
        if(dados.containsKey("email")) {
            pessoaJuridicaExistente.setEmail((String) dados.get("email"));
        }
        if(dados.containsKey("cnpj")) {
            pessoaJuridicaExistente.setCnpj((String) dados.get("cnpj"));
        }
        if(dados.containsKey("razaoSocial")) {
            pessoaJuridicaExistente.setCnpj((String) dados.get("razaoSocial"));
        }

        return repository.save(pessoaJuridicaExistente);        
    }

    public void deletaPessoaJuridica(Integer codPessoa) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        repository.delete(pessoaJuridicaExistente);
    }
    
}
