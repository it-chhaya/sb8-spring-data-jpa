package co.istad.sb8datajpa.repository;

import co.istad.sb8datajpa.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository
        extends CrudRepository<Category, Integer> {
}
