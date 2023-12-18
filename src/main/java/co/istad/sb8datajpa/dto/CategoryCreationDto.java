package co.istad.sb8datajpa.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreationDto(
        @NotBlank
        String name,
        String description,
        String icon
) {
}
