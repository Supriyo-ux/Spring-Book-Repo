package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Book;
import com.javatpoint.service.BookService;

//mark class as Controller
@RestController
@RequestMapping(value = "/book")
public class BooksController {
//autowire the BookService class
	@Autowired
	BookService BookService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/getAllBooks")
	private Iterable<Book> getAllBooks() {
		return BookService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/bookbyId/{bookid}")
	private Book getBooks(@PathVariable("bookid") int bookid) {
		return BookService.getBookById(bookid);
	}

//creating a delete mapping that deletes a specified book
	@DeleteMapping("/deletebook/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		BookService.delete(bookid);
	}

//creating post mapping that post the book detail in the database
	@PostMapping("/createbooks")
	private int saveBook(@RequestBody Book books) {
		BookService.saveOrUpdate(books);;
		return books.getBookid();
	}

//creating put mapping that updates the book detail 
	@PutMapping("/updatebooks")
	private Book update(@RequestBody Book books) {
		BookService.saveOrUpdate(books);
		//BookService.update(books);
		return books;
	}
}
