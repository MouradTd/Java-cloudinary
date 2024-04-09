package com.example.Crud_App.Repository;


import com.example.Crud_App.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
