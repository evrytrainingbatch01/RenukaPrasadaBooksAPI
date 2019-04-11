package com.evry.SpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evry.SpringBoot.entity.Book;


@Repository
public class BookDAOHibernateImpl implements BookDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public BookDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Book> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Book> theQuery =
				currentSession.createQuery("from Book", Book.class);
		
		// execute query and get result list
		List<Book> books = theQuery.getResultList();
		
		// return the results		
		return books;
	}


	@Override
	public Book findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the book
		Book theBook =
				currentSession.get(Book.class, theId);
		
		// return the employee
		return theBook;
	}


	@Override
	public void save(Book theBook) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save Book
		currentSession.saveOrUpdate(theBook);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Book where id=:BookId");
		theQuery.setParameter("BookId", theId);
		
		theQuery.executeUpdate();
	}

}







