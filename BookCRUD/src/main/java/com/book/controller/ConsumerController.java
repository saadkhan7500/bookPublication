package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entities.Consumer;
import com.book.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/Consumer")
	public List<Consumer> getAllConsumer()
	{
		return consumerService.getAllConsumer();
	}
	
	@GetMapping("/Consumer/{id}")
	public Consumer getConsumer(@PathVariable("id") int id)
	{
		return consumerService.getConsumer(id);
	}
	
	@PostMapping("/Consumer")
	public Consumer createConsumer(@RequestBody Consumer Consumer)
	{
		return consumerService.createConsumer(Consumer);
	}
	
	@PutMapping("/Consumer/{id}")
	public Consumer updateConsumer(@RequestBody Consumer consumer ,@PathVariable("id") int id)
	{
		return consumerService.updateConsumer(consumer, id);
	}
	
	@DeleteMapping("/Consumer/{id}")
	public void deleteConsumer(@PathVariable("id") int id)
	{
		consumerService.deleteConsumer(id);
	}
	
}
