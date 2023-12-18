package co.istad.sb8datajpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String icon;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;

}
