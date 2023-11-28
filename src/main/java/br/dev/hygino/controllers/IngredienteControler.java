package br.dev.hygino.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.services.IngredienteService;

@RestController
@RequestMapping("api/v1/ingrediente")
public class IngredienteControler {

    private final IngredienteService ingredienteService;

    public IngredienteControler(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }
}
