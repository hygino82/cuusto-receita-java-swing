package br.dev.hygino.services;

import org.springframework.stereotype.Service;

import br.dev.hygino.repositories.IngredienteRepository;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }
}
