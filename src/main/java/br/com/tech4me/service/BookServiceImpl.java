package br.com.tech4me.service;

import br.com.tech4me.model.Book;
import br.com.tech4me.repository.BooksRepository;
import br.com.tech4me.view.shared.BookDataTransfer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksRepository repository;

    @Override
    public List<BookDataTransfer> getAllBooks() {
        List<Book> books = repository.findAll();
        return books.stream()
                .map(b -> new ModelMapper().map(b, BookDataTransfer.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return repository.findById(id);
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
