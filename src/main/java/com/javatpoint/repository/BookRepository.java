package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
import com.javatpoint.model.Book;
public interface BookRepository extends CrudRepository<Book, Integer>
{
}
