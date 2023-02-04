package com.book.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author auth;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Book(int id, String name, Author auth) {
		super();
		this.id = id;
		this.name = name;
		this.auth = auth;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", auth=" + auth + "]";
	}
	
	
	
	
	

}
