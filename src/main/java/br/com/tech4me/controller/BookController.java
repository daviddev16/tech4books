package br.com.tech4me.controller;

import br.com.tech4me.model.Book;
import br.com.tech4me.service.BookService;
import br.com.tech4me.view.model.BookResponse;
import br.com.tech4me.view.shared.BookDataTransfer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookResponse>> allBooks(){

        List<BookDataTransfer> bookDataTransfers = service.getAllBooks();
        List<BookResponse> bookResponses = bookDataTransfers.stream()
                .map(bdt -> new ModelMapper().map(bdt, BookResponse.class))
                .collect(Collectors.toUnmodifiableList());

        return new ResponseEntity<List<BookResponse>>(bookResponses, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> bookById(@PathVariable String id){
        Optional<Book> bookValue = service.getBookById(id);
        return bookValue.isPresent() ? new ResponseEntity<Book>(bookValue.get(), HttpStatus.FOUND) :
                new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<Book>(service.addBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book updateBook, @PathVariable String id){
        return new ResponseEntity<Book>(service.updateBookById(id, updateBook), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id){
        service.deleteBookById(id);
        return new ResponseEntity<String>("Livro \"" + id + "\" removido.", HttpStatus.NO_CONTENT);
    }

}
