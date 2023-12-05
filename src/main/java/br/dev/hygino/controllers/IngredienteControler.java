package br.dev.hygino.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(ingredienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ingredienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorid(@PathVariable Long id){
        ingredienteService.removerPorid(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
