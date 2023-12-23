package co.istad.sb8datajpa.init;

import co.istad.sb8datajpa.entity.Role;
import co.istad.sb8datajpa.entity.User;
import co.istad.sb8datajpa.repository.RoleRepository;
import co.istad.sb8datajpa.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostConstruct
    void init() {

        // Insert role: ADMIN, USER, STUDENT, INSTRUCTOR
        Role user = Role.builder().name("USER").build();
        Role admin = Role.builder().name("ADMIN").build();
        Role student = Role.builder().name("STUDENT").build();
        Role instructor = Role.builder().name("INSTRUCTOR").build();
        //roleRepository.saveAll(List.of(user, admin, student, instructor));

        // Insert user:
        User userAdmin = User.builder()
                .username("admin")
                .email("admin@istad.co")
                .password("admin@123")
                .familyName("Chan")
                .givenName("Chhaya")
                .gender("Male")
                .dob(LocalDate.of(1990, 11, 11))
                .biography("IT Instructor at CSTAD")
                .isDeleted(false)
                .roles(Set.of(user, admin))
                .build();
        userRepository.save(userAdmin);
    }

}
