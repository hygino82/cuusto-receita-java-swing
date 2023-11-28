package br.dev.hygino.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dto.IngredienteDTO;
import br.dev.hygino.dto.InserirIngredienteDTO;
import br.dev.hygino.services.IngredienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/ingrediente")
public class IngredienteControler {

    private final IngredienteService ingredienteService;

    public IngredienteControler(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @PostMapping
    public ResponseEntity<IngredienteDTO> inserir(@RequestBody @Valid InserirIngredienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteService.inserir(dto));
    }
}
