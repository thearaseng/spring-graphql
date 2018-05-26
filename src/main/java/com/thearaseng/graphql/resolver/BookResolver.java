package com.thearaseng.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thearaseng.graphql.model.Author;
import com.thearaseng.graphql.model.Book;
import com.thearaseng.graphql.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}