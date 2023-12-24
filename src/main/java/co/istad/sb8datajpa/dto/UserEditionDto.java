package co.istad.sb8datajpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UserEditionDto(@NotBlank
                             String username,
                             @NotBlank
                             @Email
                             String email,
                             String familyName,
                             String givenName,
                             String gender,
                             LocalDate dob,
                             String biography) {
}
