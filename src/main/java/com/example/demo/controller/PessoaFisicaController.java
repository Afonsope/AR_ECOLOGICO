package com.example.demo.controller;

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

import com.example.demo.database.model.PessoaFisicaEntity;
import com.example.demo.dto.PessoaFisicaDto;
import com.example.demo.service.PessoaFisicaService;

@RestController 
@RequestMapping("/PessoasFisicas")
public class PessoaFisicaController {

    private final PessoaFisicaService service;

    public PessoaFisicaController(PessoaFisicaService service) {
        this.service = service;
    }

    @PostMapping
    public PessoaFisicaEntity salvarPessoa(@RequestBody PessoaFisicaDto pessoaFisica) {
        return service.salvaPessoa(pessoaFisica);
    }

    @GetMapping 
    public List<PessoaFisicaEntity> listarTodasPessoasFisicas() {
        return service.listarTodasPessoasFisicas();
    }

    @GetMapping("/{codPessoa}")
    public List<PessoaFisicaEntity> verPessoaFisica(@PathVariable Integer codPessoa) {
        return service.verPessoaFisica(codPessoa);
    }

    @PutMapping("/{codPessoa}")
    public PessoaFisicaEntity alterarPessoaFisica(@PathVariable Integer codPessoa, @RequestBody PessoaFisicaDto pessoa) {
        return service.atualizarPessoaFisica(codPessoa, pessoa);
    }

    @PatchMapping("/{codPessoa}")
    public PessoaFisicaEntity atualizaPessoaFisicaParcial(@PathVariable Integer codPessoa, @RequestBody Map<String, Object> dados) {
        return service.atualizaPessoaFisicaParcial(codPessoa, dados);
    }

    @DeleteMapping("/{codPessoa}")
    public void deletaPessoa(Integer codPessoa) {
        service.deletaPessoaFisica(codPessoa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
