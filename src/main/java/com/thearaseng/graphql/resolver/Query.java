package com.thearaseng.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thearaseng.graphql.model.Author;
import com.thearaseng.graphql.model.Book;
import com.thearaseng.graphql.repository.AuthorRepository;
import com.thearaseng.graphql.repository.BookRepository;

public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findOne(id);
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
