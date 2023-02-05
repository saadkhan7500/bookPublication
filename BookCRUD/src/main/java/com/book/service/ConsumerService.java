package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entities.Consumer;
import com.book.repository.ConsumerRepository;

@Service
public class ConsumerService {
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	
	public List<Consumer> getAllConsumer()
	{
		List<Consumer> Consumer=(List<Consumer>) consumerRepository.findAll();
		return Consumer;
	}
	
	public Consumer getConsumer(int id)
	{
		return consumerRepository.findById(id);
	}
	
	public Consumer createConsumer(Consumer c)
	{
		return consumerRepository.save(c);
	}
	
	public Consumer updateConsumer(Consumer c,int id)
	{
		Consumer consumer=consumerRepository.findById(id);
		consumer.setName(c.getName());
		consumer.setAddress(c.getAddress());
		return consumerRepository.save(consumer);
	}
	
	public void deleteConsumer(int id)
	{
		 consumerRepository.deleteById(id);
	}
}
