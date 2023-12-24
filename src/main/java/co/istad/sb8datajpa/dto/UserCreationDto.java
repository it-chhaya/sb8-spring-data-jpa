package co.istad.sb8datajpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserCreationDto(@NotBlank
                              String username,
                              @NotBlank
                              @Email
                              String email,
                              @NotBlank
                              String password,
                              @NotEmpty
                              Set<@NotNull Integer> roleIds) {
}
