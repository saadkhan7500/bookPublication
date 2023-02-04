package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entities.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	private static List<Book> list=new ArrayList<Book>();
	
//	static {
//		
//		list.add(new Book(1,"Java","Mohammad Saad"));
//		list.add(new Book(2,"Pyhton","Mohammad Aasim"));
//		list.add(new Book(3,"PHP","Mohammad Ateek"));
//	}
	
	public List<Book> getAllBooks()
	{
		return list=(List<Book>)bookRepository.findAll();
	}
	
	public Book getBook(int id)
	{
		Book book=null;
		try
		{
//			book=list.stream().filter(e->e.getId()==id).findFirst().get();
			book=bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
    
	public void addBook(Book book)
	{
        //list.add(book);
		bookRepository.save(book);
	}
	
	
//	public void deleteBook(int id)
//	{
//	   list.forEach(e->
//	   {
//		   int newid=e.getId();
//		   if(newid==id)
//		   {
//			   list.remove(e);
//		   }
//	   });	
//	}
	
	public void deleteBook(int id)
	{
		//list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book,int id)
	{
//		list.stream().map(e->
//		{
//			if(e.getId()==id)
//			{
//				e.setName(book.getName());
//				e.setAuth(book.getAuth());
//			}
//			return e;
//		}).collect(Collectors.toList());
		
		Book b=bookRepository.findById(id);
		b.setName(book.getName());
		b.setAuth(book.getAuth());
		bookRepository.save(b);
	}
	
}
