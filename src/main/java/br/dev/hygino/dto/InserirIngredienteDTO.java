package br.dev.hygino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InserirIngredienteDTO(
        @NotBlank String nome,
        String descricao,
        @NotNull Double valorEmbalagem,
        @NotNull Double quantidadeEmbalagem,
        @NotNull Double quantidadeUtilizada,
        @NotBlank String tipo,
        @NotBlank String unidade) {
}
