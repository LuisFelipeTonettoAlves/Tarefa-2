package com.example.GameStore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DesenvolvedoraRequestDTO(
        @NotBlank(message = "Preencha o nome")
        String nome,
        @NotBlank (message = "Preencha o país")
        String pais,

        @Min(value = 1972, message = "ano de fundação menor que 1972")
        @Max(value = 2026, message = "ano de fundação maior que 2026")
        Integer anoFundacao
) {
}
