package br.com.tharsissantana.graphql.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.tharsissantana.graphql.exception.BookNotFoundException;
import br.com.tharsissantana.graphql.model.Author;
import br.com.tharsissantana.graphql.model.Book;
import br.com.tharsissantana.graphql.repository.AuthorRepository;
import br.com.tharsissantana.graphql.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);

		authorRepository.save(author);

		return author;
	}

	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setPageCount(pageCount != null ? pageCount : 0);

		bookRepository.save(book);

		return book;
	}

	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(Integer pageCount, Long id) {
		Optional<Book> book = bookRepository.findById(id);

		if (!book.isPresent()) {
			throw new BookNotFoundException("The book to be updated was not found", id);
		}

		Book updateBook = book.get();
		updateBook.setPageCount(pageCount);

		bookRepository.save(updateBook);

		return updateBook;
	}
}
