package com.halseyzsmith.hzssbactuator.repositories;

import com.halseyzsmith.hzssbactuator.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
