package br.dev.hygino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.hygino.entities.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
