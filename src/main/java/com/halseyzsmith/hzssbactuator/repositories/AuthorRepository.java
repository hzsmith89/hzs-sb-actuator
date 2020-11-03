package com.halseyzsmith.hzssbactuator.repositories;

import com.halseyzsmith.hzssbactuator.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
