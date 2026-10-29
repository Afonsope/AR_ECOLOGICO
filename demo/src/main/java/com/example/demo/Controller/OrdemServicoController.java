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

import com.example.demo.Model.OrdemServicoEntity;
import com.example.demo.Service.OrdemServicoService;

@RestController 
@RequestMapping("/OrdensServico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping
    public OrdemServicoEntity salvarOrdemServico(@RequestBody OrdemServicoEntity ordemServico) {
        return service.salvaOrdemServico(ordemServico);
    }

    @GetMapping 
    public List<OrdemServicoEntity> listarTodasOrdensServico() {
        return service.listarTodasOrdensServico();
    }

    @GetMapping("/{codOrdemServico}")
    public List<OrdemServicoEntity> verOrdemServico(@PathVariable Integer codOrdemServico) {
        return service.verOrdemServico(codOrdemServico);
    }

    @PutMapping("/{codOrdemServico}")
    public OrdemServicoEntity alterarOrdemServico(@PathVariable Integer codOrdemServico, @RequestBody OrdemServicoEntity ordemServico) {
        return service.atualizarOrdemServico(codOrdemServico, ordemServico);
    }

    @PatchMapping("/{codOrdemServico}")
    public OrdemServicoEntity atualizaOrdemServicoParcial(@PathVariable Integer codOrdemServico, @RequestBody Map<String, Object> dados) {
        return service.atualizaOrdemServicoParcial(codOrdemServico, dados);
    }

    @DeleteMapping("/{codOrdemServico}")
    public void deletaOrdemServico(@PathVariable Integer codOrdemServico) {
        service.deleta(codOrdemServico);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
