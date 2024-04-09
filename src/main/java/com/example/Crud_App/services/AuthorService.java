package com.example.Crud_App.services;

import com.example.Crud_App.DTO.AuthorDTO;
import com.example.Crud_App.DTO.BookDTO;
import com.example.Crud_App.Repository.AuthorRepository;
import com.example.Crud_App.Repository.BookRepository;
import com.example.Crud_App.model.Author;
import com.example.Crud_App.model.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    public static  AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<AuthorDTO> getAllAuthors() {
        List<Author> author = authorRepository.findAll();
        return author.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO, author);
        author = authorRepository.save(author);
        return convertToDTO(author);
    }
    public static Author findOrCreateAuthor(String authorName) {
        // Try to find the author by name
        Author author = authorRepository.findByName(authorName);

        // If author doesn't exist, create a new one
        if (author == null) {
            author = new Author();
            author.setName(authorName);
            author = authorRepository.save(author);
        }
        return author;
    }

    private AuthorDTO convertToDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }
}
