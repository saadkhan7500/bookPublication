package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entities.Book;
import com.book.service.BookService;

@RestController
public class MainController {
	
	@Autowired
	public BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list=bookService.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));	
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{

		Book b=null;
		b=bookService.getBook(id);
		if(b==null)
		{
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		return ResponseEntity.of(Optional.of(b));
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book )
	{
		try
		{
			bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id")int  id)
	{
		try
		{
		  bookService.deleteBook(id);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody Book book,@PathVariable("id") int id)
	{
		try
		{
			System.out.println(book);
			System.out.println(id);
			bookService.updateBook(book,id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
