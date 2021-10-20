package br.com.tharsissantana.graphql.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.com.tharsissantana.graphql.model.Author;
import br.com.tharsissantana.graphql.model.Book;
import br.com.tharsissantana.graphql.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
	
	private AuthorRepository authorRepository;

	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
		Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		
		return author.isPresent() ? author.get() : null;
	}
}
