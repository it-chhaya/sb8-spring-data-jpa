package co.istad.sb8datajpa.repository;

import co.istad.sb8datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        SELECT u
        FROM User AS u
        WHERE (u.username = ?1
        OR
        u.email = ?1)
        AND
        u.isDeleted = ?2
    """)
    Optional<User> login(String usernameOrEmail, Boolean isDeleted);

    Optional<User> findByEmailAndIsDeleted(String email, Boolean isDeleted);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndIsDeleted(String username, Boolean isDeleted);

    List<User> findByFamilyNameContainsIgnoreCase(String familyName);

    List<User> findByGenderContainsIgnoreCase(String gender);
}
