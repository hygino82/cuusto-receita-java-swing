package br.dev.hygino.dto;

import br.dev.hygino.entities.Ingrediente;
import br.dev.hygino.types.Tipo;
import br.dev.hygino.types.Unidade;

public record IngredienteDTO(
        Long id,
        String nome,
        String descricao,
        Double quantidadeUtilizada,
        Double custo,
        Tipo tipo,
        Unidade unidade) {

    public IngredienteDTO(Ingrediente entity) {
        this(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getQuantidadeUtilizada(),
                entity.custo(),
                entity.getTipo(),
                entity.getUnidade());
    }
}
