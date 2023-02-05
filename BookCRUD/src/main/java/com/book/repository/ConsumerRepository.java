package com.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.entities.Consumer;


@Repository
public interface ConsumerRepository  extends CrudRepository<Consumer, Integer>{
   
	public Consumer findById(int id);
}
