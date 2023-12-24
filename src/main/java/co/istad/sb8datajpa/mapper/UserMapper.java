package co.istad.sb8datajpa.mapper;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.dto.UserDto;
import co.istad.sb8datajpa.dto.UserEditionDto;
import co.istad.sb8datajpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserCreationDto(UserCreationDto creationDto);

    void fromUserEditionDto(@MappingTarget User user,
                            UserEditionDto userEditionDto);

    UserDto toUserDto(User user);

}
