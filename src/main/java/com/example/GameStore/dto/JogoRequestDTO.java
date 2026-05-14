package com.example.GameStore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record JogoRequestDTO(
        @NotBlank(message = "Preencha o titulo")
        String titulo,
        @NotBlank(message = "Preencha o genero")
        String genero,
        @NotNull(message = "Preencha o preço")
        @Positive
        Double preco,
        @NotNull(message = "Preencha  a classificação indicativa")
        @Max(value = 18)
        Integer classificacaoIndicativa,
        @NotBlank(message = "Preencha na descrição")
        String descricao,
        @NotNull(message = "Preencha a desenvolvedora")
        Long idDesenvolvedora
) {
}
