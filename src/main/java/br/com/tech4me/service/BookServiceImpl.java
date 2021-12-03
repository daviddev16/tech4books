package br.com.tech4me.service;

import br.com.tech4me.model.Book;
import br.com.tech4me.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBookById(String id, Book newBook) {
        newBook.setId(id);
        return repository.save(newBook);
    }

    @Override
    public void deleteBookById(String id) {
        repository.deleteById(id);
    }
}
