package br.dev.hygino.services;

import org.springframework.stereotype.Service;

import br.dev.hygino.dto.IngredienteDTO;
import br.dev.hygino.dto.InserirIngredienteDTO;
import br.dev.hygino.entities.Ingrediente;
import br.dev.hygino.repositories.IngredienteRepository;
import jakarta.validation.Valid;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public IngredienteDTO inserir(@Valid InserirIngredienteDTO dto) {
        Ingrediente entity = new Ingrediente(dto);
        entity = ingredienteRepository.save(entity);
        return new IngredienteDTO(entity);
    }
}