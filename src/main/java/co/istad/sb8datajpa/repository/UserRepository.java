package co.istad.sb8datajpa.repository;

import co.istad.sb8datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
