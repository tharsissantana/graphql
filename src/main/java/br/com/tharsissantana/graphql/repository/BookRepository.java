package br.com.tharsissantana.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tharsissantana.graphql.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
