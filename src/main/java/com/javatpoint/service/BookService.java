package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Book;
import com.javatpoint.repository.BookRepository;
//defining the business logic
@Service
public class BookService 
{
@Autowired
BookRepository BookRepository;
//getting all Book record by using the method findaAll() of CrudRepository
public Iterable<Book> getAllBooks() 
{
//List<Book> Book = new ArrayList<Book>();
 return BookRepository.findAll();

}
//getting a specific record by using the method findById() of CrudRepository
public Book getBookById(int id) 
{
return BookRepository.findById(id).get();
}
//saving a specific record by using the method save() of CrudRepository
public void saveOrUpdate(Book Book) 
{
BookRepository.save(Book);
}
//deleting a specific record by using the method deleteById() of CrudRepository
public void delete(int id) 
{
BookRepository.deleteById(id);
}
//updating a record
public void update(Book book) 
{
BookRepository.save(book);
}
 
}