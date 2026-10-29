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

import com.example.demo.Model.PrestadorServicoEntity;
import com.example.demo.Service.PrestadorServicoService;

@RestController 
@RequestMapping("/PrestadoresServicos")
public class PrestadorServicoController {

    private final PrestadorServicoService service;

    public PrestadorServicoController(PrestadorServicoService service) {
        this.service = service;
    }

    @PostMapping
    public PrestadorServicoEntity salvarPessoa(@RequestBody PrestadorServicoEntity prestadorServico) {
        return service.salvaPessoa(prestadorServico);
    }

    @GetMapping 
    public List<PrestadorServicoEntity> listarTodosPrestadoresServicos() {
        return service.listarTodosPrestadoresServicos();
    }

    @GetMapping("/{codPessoa}")
    public List<PrestadorServicoEntity> verPrestadorServico(@PathVariable Integer codPessoa) {
        return service.verPrestadorServico(codPessoa);
    }

    @PutMapping("/{codPessoa}")
    public PrestadorServicoEntity alterarPrestadorServico(@PathVariable Integer codPessoa, @RequestBody PrestadorServicoEntity pessoa) {
        return service.atualizarPrestadorServico(codPessoa, pessoa);
    }

    @PatchMapping("/{codPessoa}")
    public PrestadorServicoEntity atualizaPrestadorServicoParcial(@PathVariable Integer codPessoa, @RequestBody Map<String, Object> dados) {
        return service.atualizaPrestadorServicoParcial(codPessoa, dados);
    }

    @DeleteMapping("/{codPessoa}")
    public void deletaPessoa(Integer codPessoa) {
        service.deletaPrestadorServico(codPessoa);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarErroJson(
            HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body("Erro ao ler JSON: " + ex.getMostSpecificCause().getMessage());
    }

}
