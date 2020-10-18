package com.filipmoszczynski.module.books.dto;

public class BookForm {

    private String author;
    private String title;
    private String isbn;
    private String lang;

    public String getAuthor() {
        return author;
    }

    public BookForm setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookForm setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public BookForm setLang(String lang) {
        this.lang = lang;
        return this;
    }
}
