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

import com.example.demo.Model.ContratoEntity;
import com.example.demo.Service.ContratoService;

@RestController 
@RequestMapping("/Contratos")
public class ContratoController {

    private final ContratoService service;

    public ContratoController(ContratoService service) {
        this.service = service;
    }

    @PostMapping
    public ContratoEntity salvarContrato(@RequestBody ContratoEntity contrato) {
        return service.salvaContrato(contrato);
    }

    @GetMapping 
    public List<ContratoEntity> listarTodosContratos() {
        return service.listarTodosContratos();
    }

    @GetMapping("/{codContrato}")
    public List<ContratoEntity> verContrato(@PathVariable Integer codContrato) {
        return service.verContrato(codContrato);
    }

    @PutMapping("/{codContrato}")
    public ContratoEntity alterarContrato(@PathVariable Integer codContrato, @RequestBody ContratoEntity contrato) {
        return service.atualizarContrato(codContrato, contrato);
    }

    @PatchMapping("/{codContrato}")
    public ContratoEntity atualizaContratoParcial(@PathVariable Integer codContrato, @RequestBody Map<String, Object> dados) {
        return service.atualizaContratoParcial(codContrato, dados);
    }

    @DeleteMapping("/{codContrato}")
    public void deletaContrato(@PathVariable Integer codContrato) {
        service.deleta(codContrato);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
