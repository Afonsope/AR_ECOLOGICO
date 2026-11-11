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

import com.example.demo.database.model.ContratoEquipamentoEntity;
import com.example.demo.database.model.ContratoEquipamentoId;
import com.example.demo.dto.ContratoEquipamentoDto;
import com.example.demo.service.ContratoEquipamentoService;

@RestController
@RequestMapping("/ContratosEquipamentos")
public class ContratoEquipamentoController {

    private final ContratoEquipamentoService service;

    public ContratoEquipamentoController(ContratoEquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ContratoEquipamentoEntity salvarContratoEquipamento(
            @RequestBody ContratoEquipamentoDto contratoEquipamento) {
        return service.salvaContratoEquipamento(contratoEquipamento);
    }

    @GetMapping
    public List<ContratoEquipamentoEntity> listarTodosContratosEquipamentos() {
        return service.listarTodosContratosEquipamentos();
    }

    @GetMapping("/{contratoCod}/{equipamentoCod}")
    public List<ContratoEquipamentoEntity> verContratoEquipamento(
            @PathVariable Integer contratoCod, @PathVariable Integer equipamentoCod) {
        return service.verContratoEquipamento(criarId(contratoCod, equipamentoCod));
    }

    @PutMapping("/{contratoCod}/{equipamentoCod}")
    public ContratoEquipamentoEntity alterarContratoEquipamento(
            @PathVariable Integer contratoCod,
            @PathVariable Integer equipamentoCod,
            @RequestBody ContratoEquipamentoDto contratoEquipamento) {
        return service.atualizarContratoEquipamento(
                criarId(contratoCod, equipamentoCod), contratoEquipamento);
    }

    @PatchMapping("/{contratoCod}/{equipamentoCod}")
    public ContratoEquipamentoEntity atualizaContratoEquipamentoParcial(
            @PathVariable Integer contratoCod,
            @PathVariable Integer equipamentoCod,
            @RequestBody Map<String, Object> dados) {
        return service.atualizaContratoEquipamentoParcial(criarId(contratoCod, equipamentoCod), dados);
    }

    @DeleteMapping("/{contratoCod}/{equipamentoCod}")
    public void deletaContratoEquipamento(
            @PathVariable Integer contratoCod, @PathVariable Integer equipamentoCod) {
        service.deletaContratoEquipamento(criarId(contratoCod, equipamentoCod));
    }

    private ContratoEquipamentoId criarId(Integer contratoCod, Integer equipamentoCod) {
        return new ContratoEquipamentoId(contratoCod, equipamentoCod);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }
}
