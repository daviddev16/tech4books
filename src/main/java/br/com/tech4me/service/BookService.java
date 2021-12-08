package br.com.tech4me.service;

import br.com.tech4me.model.Book;
import br.com.tech4me.view.shared.BookDataTransfer;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDataTransfer> getAllBooks();

    Optional<Book> getBookById(String id);

    Book addBook(Book book);

    Book updateBookById(String id, Book newBook);

    void deleteBookById(String id);

}
