package co.istad.sb8datajpa.controller;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
