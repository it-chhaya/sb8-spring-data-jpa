package co.istad.sb8datajpa.controller;

import co.istad.sb8datajpa.base.BaseSuccess;
import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.dto.UserEditionDto;
import co.istad.sb8datajpa.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNew(@Valid @RequestBody UserCreationDto creationDto) {
        userService.createNew(creationDto);
    }

    @PutMapping("/{id}")
    BaseSuccess<?> editById(@PathVariable Long id, @Valid @RequestBody UserEditionDto editionDto) {
        return BaseSuccess.builder()
                .data(userService.editById(id, editionDto))
                .code(HttpStatus.OK.value())
                .message("User has been edited successfully")
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("/{id}")
    BaseSuccess<?> findById(@PathVariable Long id) {
        return BaseSuccess.builder()
                .data(userService.findById(id))
                .code(HttpStatus.OK.value())
                .message("User has been found successfully")
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
