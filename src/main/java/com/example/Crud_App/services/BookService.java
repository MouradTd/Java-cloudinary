package com.example.Crud_App.services;


import com.example.Crud_App.DTO.BookDTO;
import com.example.Crud_App.Repository.BookRepository;
import com.example.Crud_App.Utils.Utils;
import com.example.Crud_App.model.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class BookService {
    private final BookRepository bookRepository;
    private final Utils utils;

    @Autowired
    public BookService(BookRepository bookRepository, Utils utils) {
        this.bookRepository = bookRepository;
        this.utils = utils;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return convertToDTO(book);
        }
        return null;
    }

    public BookDTO addBook(BookDTO bookDTO, MultipartFile file) throws IOException {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(AuthorService.findOrCreateAuthor(bookDTO.getAuthor())); // Set author

        // Save the file
        String filePath = utils.uploadFile(file);
         book.setFile(filePath);

        book = bookRepository.save(book);
        return convertToDTO(book);
    }





    private BookDTO convertToDTO(Book book) {
    BookDTO bookDTO = new BookDTO();
    BeanUtils.copyProperties(book, bookDTO);
    if (book.getAuthor() != null) {
        bookDTO.setAuthor(book.getAuthor().getName());
    }
    return bookDTO;
}
}

