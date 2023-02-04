package com.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String name;
	private String addr;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int aid, String name, String addr) {
		super();
		this.aid = aid;
		this.name = name;
		this.addr = addr;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + ", addr=" + addr + "]";
	}
	
	

}
