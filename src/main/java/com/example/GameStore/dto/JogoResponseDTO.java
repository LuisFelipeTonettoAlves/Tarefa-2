package com.example.GameStore.dto;

public record JogoResponseDTO(
        Long idJogo,
        String titulo,
        String genero,
        Double preco,
        Integer classificacaoIndicativa,
        String descricao,
        Long idDesenvolvedora
) {
}
