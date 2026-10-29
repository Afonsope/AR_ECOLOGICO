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

import com.example.demo.Model.EquipamentoEntity;
import com.example.demo.Service.EquipamentoService;

@RestController 
@RequestMapping("/Equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public EquipamentoEntity salvarEquipamento(@RequestBody EquipamentoEntity equipamento) {
        return service.salvaEquipamento(equipamento);
    }

    @GetMapping 
    public List<EquipamentoEntity> listarTodosEquipamentos() {
        return service.listarTodosEquipamentos();
    }

    @GetMapping("/{codEquipamento}")
    public List<EquipamentoEntity> verEquipamento(@PathVariable Integer codEquipamento) {
        return service.verEquipamento(codEquipamento);
    }

    @PutMapping("/{codEquipamento}")
    public EquipamentoEntity alterarEquipamento(@PathVariable Integer codEquipamento, @RequestBody EquipamentoEntity equipamento) {
        return service.atualizarEquipamento(codEquipamento, equipamento);
    }

    @PatchMapping("/{codEquipamento}")
    public EquipamentoEntity atualizaEquipamentoParcial(@PathVariable Integer codEquipamento, @RequestBody Map<String, Object> dados) {
        return service.atualizaEquipamentoParcial(codEquipamento, dados);
    }

    @DeleteMapping("/{codEquipamento}")
    public void deletaEquipamento(@PathVariable Integer codEquipamento) {
        service.deleta(codEquipamento);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
