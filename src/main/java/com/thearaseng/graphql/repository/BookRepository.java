package com.thearaseng.graphql.repository;

import com.thearaseng.graphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
