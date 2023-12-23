package co.istad.sb8datajpa;

import co.istad.sb8datajpa.entity.User;
import co.istad.sb8datajpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Sb8DataJpaApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void test_login() {
        User loggedInUser = userRepository.login(
                "admin@istad.co", false
        ).orElseThrow();
        System.out.println(loggedInUser);
    }

    @Test
    void test_findUserByUsernameOrEmail() {
        System.out.println(userRepository.findByUsernameAndIsDeleted("admin",  false));
    }

    @Test
    void test_findByFamilyNameContainsIgnoreCase() {
        List<User> users = userRepository.findByFamilyNameContainsIgnoreCase("k");
        System.out.println(users);
    }

}
