package co.istad.sb8datajpa.service;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.dto.UserDto;
import co.istad.sb8datajpa.dto.UserEditionDto;
import org.springframework.data.domain.Page;

public interface UserService {

    // Create new user:
    // Return type is DTO:
    // Request data is DTO:
    void createNew(UserCreationDto creationDto);

    UserDto editById(Long id, UserEditionDto editionDto);

    UserDto findById(Long id);

    Page<?> findList(int pageNumber, int pageSize);

    void enableById(Long id);

    void disableById(Long id);

    void deleteById(Long id);

}
