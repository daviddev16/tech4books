package br.com.tech4me.service;

import br.com.tech4me.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(String id);

    Book addBook(Book book);

    Book updateBookById(String id, Book newBook);

    void deleteBookById(String id);


}
