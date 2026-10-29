package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.PessoaJuridicaEntity;
import com.example.demo.Service.PessoaJuridicaService;

@RestController 
@RequestMapping("/PessoasJuridicas")
public class PessoaJuridicaController {

    private final PessoaJuridicaService service;

    public PessoaJuridicaController(PessoaJuridicaService service) {
        this.service = service;
    }

    @PostMapping
    public PessoaJuridicaEntity salvarPessoa(@RequestBody PessoaJuridicaEntity pessoaJuridica) {
        return service.salvaPessoa(pessoaJuridica);
    }

    @GetMapping 
    public List<PessoaJuridicaEntity> listarTodasPessoasFisicas() {
        return service.listarTodasPessoasFisicas();
    }

    @GetMapping("/{codPessoa}")
    public List<PessoaJuridicaEntity> verPessoaJuridica(@PathVariable Integer codPessoa) {
        return service.verPessoaJuridica(codPessoa);
    }

    @PutMapping("/{codPessoa}")
    public PessoaJuridicaEntity alterarPessoaJuridica(@PathVariable Integer codPessoa, @RequestBody PessoaJuridicaEntity pessoa) {
        return service.atualizarPessoaJuridica(codPessoa, pessoa);
    }

    @PatchMapping("/{codPessoa}")
    public PessoaJuridicaEntity atualizaPessoaJuridicaParcial(@PathVariable Integer codPessoa, @RequestBody Map<String, Object> dados) {
        return service.atualizaPessoaJuridicaParcial(codPessoa, dados);
    }

    @DeleteMapping("/{codPessoa}")
    public void deletaPessoa(Integer codPessoa) {
        service.deletaPessoaJuridica(codPessoa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
