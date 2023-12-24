package co.istad.sb8datajpa.mapper;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserCreationDto(UserCreationDto creationDto);

}
