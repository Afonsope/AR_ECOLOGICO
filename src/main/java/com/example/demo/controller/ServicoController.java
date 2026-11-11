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

import com.example.demo.database.model.ServicoEntity;
import com.example.demo.dto.ServicoDto;
import com.example.demo.service.ServicoService;

@RestController 
@RequestMapping("/Servicos")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @PostMapping
    public ServicoEntity salvarServico(@RequestBody ServicoDto servico) {
        return service.salvaServico(servico);
    }

    @GetMapping 
    public List<ServicoEntity> listarTodosServicos() {
        return service.listarTodosServicos();
    }

    @GetMapping("/{codServico}")
    public List<ServicoEntity> verServico(@PathVariable Integer codServico) {
        return service.verServico(codServico);
    }

    @PutMapping("/{codServico}")
    public ServicoEntity alterarServico(@PathVariable Integer codServico, @RequestBody ServicoDto servico) {
        return service.atualizarServico(codServico, servico);
    }

    @PatchMapping("/{codServico}")
    public ServicoEntity atualizaServicoParcial(@PathVariable Integer codServico, @RequestBody Map<String, Object> dados) {
        return service.atualizaServicoParcial(codServico, dados);
    }

    @DeleteMapping("/{codServico}")
    public void deletaServico(@PathVariable Integer codServico) {
        service.deleta(codServico);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
