package co.istad.sb8datajpa.repository;

import co.istad.sb8datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndIsDeleted(String email, Boolean isDeleted);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndIsDeleted(String username, Boolean isDeleted);

    List<User> findByFamilyNameContainsIgnoreCase(String familyName);

    List<User> findByGenderContainsIgnoreCase(String gender);
}
