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

import com.example.demo.database.model.ServicoRealizadoEntity;
import com.example.demo.database.model.ServicoRealizadoId;
import com.example.demo.dto.ServicoRealizadoDto;
import com.example.demo.service.ServicoRealizadoService;

@RestController
@RequestMapping("/ServicosRealizados")
public class ServicoRealizadoController {

    private final ServicoRealizadoService service;

    public ServicoRealizadoController(ServicoRealizadoService service) {
        this.service = service;
    }

    @PostMapping
    public ServicoRealizadoEntity salvarServicoRealizado(
            @RequestBody ServicoRealizadoDto servicoRealizado) {
        return service.salvaServicoRealizado(servicoRealizado);
    }

    @GetMapping
    public List<ServicoRealizadoEntity> listarTodosServicosRealizados() {
        return service.listarTodosServicosRealizados();
    }

    @GetMapping("/{osCod}/{servicoCod}")
    public List<ServicoRealizadoEntity> verServicoRealizado(
            @PathVariable Integer osCod, @PathVariable Integer servicoCod) {
        return service.verServicoRealizado(criarId(osCod, servicoCod));
    }

    @PutMapping("/{osCod}/{servicoCod}")
    public ServicoRealizadoEntity alterarServicoRealizado(
            @PathVariable Integer osCod,
            @PathVariable Integer servicoCod,
            @RequestBody ServicoRealizadoDto servicoRealizado) {
        return service.atualizarServicoRealizado(criarId(osCod, servicoCod), servicoRealizado);
    }

    @PatchMapping("/{osCod}/{servicoCod}")
    public ServicoRealizadoEntity atualizaServicoRealizadoParcial(
            @PathVariable Integer osCod,
            @PathVariable Integer servicoCod,
            @RequestBody Map<String, Object> dados) {
        return service.atualizaServicoRealizadoParcial(criarId(osCod, servicoCod), dados);
    }

    @DeleteMapping("/{osCod}/{servicoCod}")
    public void deletaServicoRealizado(
            @PathVariable Integer osCod, @PathVariable Integer servicoCod) {
        service.deletaServicoRealizado(criarId(osCod, servicoCod));
    }

    private ServicoRealizadoId criarId(Integer osCod, Integer servicoCod) {
        return new ServicoRealizadoId(osCod, servicoCod);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }
}
