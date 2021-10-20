package br.com.tharsissantana.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tharsissantana.graphql.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
