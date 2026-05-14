package com.example.GameStore.dto;

public record AvaliacaoJogoResponseDTO(
        Long idAvaliacao,
        Double nota,
        String comentario,
        Long idJogo
) {
}
