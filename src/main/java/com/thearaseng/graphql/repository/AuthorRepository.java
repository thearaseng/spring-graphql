package com.thearaseng.graphql.repository;

import com.thearaseng.graphql.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
