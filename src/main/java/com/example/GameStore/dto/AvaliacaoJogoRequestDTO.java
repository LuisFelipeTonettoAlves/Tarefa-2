package com.example.GameStore.dto;

import jakarta.validation.constraints.*;

public record AvaliacaoJogoRequestDTO(
        @NotNull(message = "Preencha a avaliação")
        Long idAvaliacao,

        @NotNull(message = "Preencha a nota")
        @DecimalMin(value = "0.0", message = "Nota menor que 0")
        @DecimalMax(value = "5.0", message = "Nota maior que 5")
        Double nota,

        @NotBlank(message = "Preencha o comentario")
        String comentario,

        @NotBlank(message = "Preencha o jogo")
        Long idJogo

) {
}
