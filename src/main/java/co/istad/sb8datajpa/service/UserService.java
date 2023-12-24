package co.istad.sb8datajpa.service;

import co.istad.sb8datajpa.dto.UserCreationDto;

public interface UserService {

    // Create new user:
    // Return type is DTO:
    // Request data is DTO:
    void createNew(UserCreationDto creationDto);

}
