package co.istad.sb8datajpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreationDto(@NotBlank
                              String username,
                              @NotBlank
                              @Email
                              String email,
                              @NotBlank
                              String password) {
}
