package com.graphqljava.tutorial.bookdetails;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;


@Component
public class GraphQLDataFetchers {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public GraphQLDataFetchers(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
             Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id")) ;
            return bookRepository.findById(id).orElse(null);
        };
    }

    public DataFetcher getAuthorByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id")) ;
            return authorRepository.findById(id).orElse(null);
        };
    }

}
