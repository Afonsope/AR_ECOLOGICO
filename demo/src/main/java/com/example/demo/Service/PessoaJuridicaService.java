package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.example.demo.Model.PessoaJuridicaEntity;
import com.example.demo.Repository.PessoaJuridicaRepository;

@Service 
public class PessoaJuridicaService {

    private final PessoaJuridicaRepository repository;

    public PessoaJuridicaService(PessoaJuridicaRepository repository){
        this.repository = repository;
    }
    
    public PessoaJuridicaEntity salvaPessoa(PessoaJuridicaEntity pessoaJuridica) {
        return repository.save(pessoaJuridica);
    }

    public List<PessoaJuridicaEntity> listarTodasPessoasFisicas() {
        return repository.findAll();
    }

    public List<PessoaJuridicaEntity> verPessoaJuridica(Integer codPessoa) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return List.of(pessoaJuridicaExistente);
    }

    public PessoaJuridicaEntity atualizarPessoaJuridica(Integer codPessoa, PessoaJuridicaEntity pessoaJuridica) {
        PessoaJuridicaEntity pessoaJuridicaExistente = repository.findById(codPessoa).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoaJuridicaExistente.setEndereco(pessoaJuridica.getEndereco());
        pessoaJuridicaExistente.setCep(pessoaJuridica.getCep());
        pessoaJuridicaExistente.setNumero(pessoaJuridica.getNumero());
        pessoaJuridicaExistente.setCidade(pessoaJuridica.getCidade());
        pessoaJuridicaExistente.setEstado(pessoaJuridica.getEstado());
        pessoaJuridicaExistente.setTelefone(pessoaJuridica.getTelefone());
        pessoaJuridicaExistente.setNome(pessoaJuridica.getNome());
        pessoaJuridicaExistente.setEmail(pessoaJuridica.getEmail());
        pessoaJuridicaExistente.setCnpj(pessoaJuridica.getCnpj());
        pessoaJuridicaExistente.setRazaoSocial(pessoaJuridica.getRazaoSocial());

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
