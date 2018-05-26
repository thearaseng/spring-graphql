package com.thearaseng.graphql.configuration;

import com.thearaseng.graphql.model.Author;
import com.thearaseng.graphql.model.Book;
import com.thearaseng.graphql.repository.AuthorRepository;
import com.thearaseng.graphql.repository.BookRepository;
import com.thearaseng.graphql.resolver.BookResolver;
import com.thearaseng.graphql.resolver.Mutation;
import com.thearaseng.graphql.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookResolver authorResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Mutation(authorRepository, bookRepository);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);

            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
        };
    }

}
