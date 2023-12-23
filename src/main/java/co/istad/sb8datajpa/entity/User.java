package co.istad.sb8datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String familyName;
    private String givenName;
    private String gender;
    private LocalDate dob;
    @Column(columnDefinition = "TEXT")
    private String biography;
    private Boolean isDeleted;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
