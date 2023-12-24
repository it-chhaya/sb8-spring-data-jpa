package co.istad.sb8datajpa.service.impl;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.dto.UserDto;
import co.istad.sb8datajpa.dto.UserEditionDto;
import co.istad.sb8datajpa.entity.Role;
import co.istad.sb8datajpa.entity.User;
import co.istad.sb8datajpa.mapper.UserMapper;
import co.istad.sb8datajpa.repository.RoleRepository;
import co.istad.sb8datajpa.repository.UserRepository;
import co.istad.sb8datajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public void createNew(UserCreationDto creationDto) {

        // Check username
        if (userRepository.existsByUsername(creationDto.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Username is already existed!");
        }

        // Check email
        // Check username
        if (userRepository.existsByEmail(creationDto.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Email is already existed!");
        }

        List<Role> roles = (List<Role>)
                roleRepository.findAllById(creationDto.roleIds());
        Set<Role> userRoles = new HashSet<>(roles);

        User user = userMapper.fromUserCreationDto(creationDto);
        user.setIsDeleted(false);
        user.setRoles(userRoles);

        userRepository.save(user);
    }

    @Override
    public UserDto editById(Long id, UserEditionDto editionDto) {

        // Check user ID has or not
        User foundUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("User Id = %d has not found in database", id)));

        userMapper.fromUserEditionDto(foundUser, editionDto);
        userRepository.save(foundUser);

        return this.findById(foundUser.getId());
    }

    @Override
    public UserDto findById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("User Id = %d has not found in database", id)));

        return userMapper.toUserDto(foundUser);
    }

    @Override
    public Page<?> findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public void enableById(Long id) {

    }

    @Override
    public void disableById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
