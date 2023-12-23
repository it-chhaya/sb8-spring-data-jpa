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
    void test_updateBiography() {
        String newBiography = """
                Now i connect my new DB with my Sping(Java) something.
                But, I don't understand why in RUN output in IJ and SQL Shell shows wrong order of lines.
                The first line in column should be ID. After should go - name,email, date,age.
                """;
        userRepository.updateBiography("student", newBiography);
    }

    @Test
    void test_login() {
        User loggedInUser = userRepository.login(
                "student", false
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
