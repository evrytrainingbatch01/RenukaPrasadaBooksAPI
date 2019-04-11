package com.evry.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evry.SpringBoot.dao.BookDAO;
import com.evry.SpringBoot.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookDAO bookDAO;

	
	
	@Override
	@Transactional
	public List<Book> findAll() {
		return bookDAO.findAll();
	}

	@Override
	@Transactional
	public Book findById(int theId) {
		return bookDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Book thebook) {
		bookDAO.save(thebook);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		bookDAO.deleteById(theId);
	}

}
