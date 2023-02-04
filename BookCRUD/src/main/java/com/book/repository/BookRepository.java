package com.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

	public Book findById(int id);
}
