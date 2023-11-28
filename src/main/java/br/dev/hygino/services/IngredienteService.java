package br.dev.hygino.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public List<IngredienteDTO> buscarTodos() {
        List<Ingrediente> lista = ingredienteRepository.findAll();
        return lista.stream().map(x -> new IngredienteDTO(x)).collect(Collectors.toList());
    }

    public IngredienteDTO buscarPorId(Long id) {
        var res = ingredienteRepository.findById(id);
        if (!res.isPresent()) {
            throw new IllegalArgumentException("Não existe ingrediente com o id: " + id);
        }
        return new IngredienteDTO(res.get());
    }
}
