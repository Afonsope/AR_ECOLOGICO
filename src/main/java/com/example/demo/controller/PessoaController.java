package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.model.PessoaEntity;
import com.example.demo.dto.PessoaDto;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/Pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public PessoaEntity salvarPessoa(@RequestBody PessoaDto pessoa) {
        return service.salvaPessoa(pessoa);
    }

    @GetMapping
    public List<PessoaEntity> listarTodasPessoas() {
        return service.listarTodasPessoas();
    }

    @GetMapping("/{codPessoa}")
    public List<PessoaEntity> verPessoa(@PathVariable Integer codPessoa) {
        return service.verPessoa(codPessoa);
    }

    @PutMapping("/{codPessoa}")
    public PessoaEntity alterarPessoa(@PathVariable Integer codPessoa, @RequestBody PessoaDto pessoa) {
        return service.atualizarPessoa(codPessoa, pessoa);
    }

    @PatchMapping("/{codPessoa}")
    public PessoaEntity atualizaPessoaParcial(
            @PathVariable Integer codPessoa, @RequestBody Map<String, Object> dados) {
        return service.atualizaPessoaParcial(codPessoa, dados);
    }

    @DeleteMapping("/{codPessoa}")
    public void deletaPessoa(@PathVariable Integer codPessoa) {
        service.deletaPessoa(codPessoa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }
}
