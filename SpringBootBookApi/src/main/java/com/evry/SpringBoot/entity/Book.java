package com.evry.SpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_name")
	private String book_name;

	@Column(name="book_author")
	private String book_author;
	
	@Column(name="prize")
	private double prize;

	public Book() {
	}

	public Book(int id, String book_name, String book_author, double prize) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.prize = prize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", book_name=" + book_name + ", book_author=" + book_author + ", prize=" + prize
				+ "]";
	}
	
	

}
