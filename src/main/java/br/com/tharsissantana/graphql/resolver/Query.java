package br.com.tharsissantana.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.tharsissantana.graphql.model.Author;
import br.com.tharsissantana.graphql.model.Book;
import br.com.tharsissantana.graphql.repository.AuthorRepository;
import br.com.tharsissantana.graphql.repository.BookRepository;

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

	public long countBooks() {
		return bookRepository.count();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
