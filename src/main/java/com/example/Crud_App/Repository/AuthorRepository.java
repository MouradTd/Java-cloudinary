package com.example.Crud_App.Repository;

import com.example.Crud_App.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends  JpaRepository<Author, Long> {
    Author findByName(String name);
}
