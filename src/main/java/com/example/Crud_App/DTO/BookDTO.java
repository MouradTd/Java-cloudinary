package com.example.Crud_App.DTO;

public class BookDTO {
    private Long id;
    private String title;
    private String author_id;

    private String File;

    // Getters and setters
    // Constructor(s)

    public BookDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author_id;
    }

    public void setAuthor(String author) {
        this.author_id = author;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }
}