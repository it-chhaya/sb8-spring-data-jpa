package co.istad.sb8datajpa.service.impl;

import co.istad.sb8datajpa.dto.UserCreationDto;
import co.istad.sb8datajpa.entity.User;
import co.istad.sb8datajpa.mapper.UserMapper;
import co.istad.sb8datajpa.repository.UserRepository;
import co.istad.sb8datajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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

        User user = userMapper.fromUserCreationDto(creationDto);
        user.setIsDeleted(false);
        userRepository.save(user);
    }
}
