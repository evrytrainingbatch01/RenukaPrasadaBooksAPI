package com.evry.SpringBoot.Service;

import java.util.List;

import com.evry.SpringBoot.entity.Book;



public interface BookService {

	public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
	
}
