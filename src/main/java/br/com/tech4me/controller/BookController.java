package br.com.tech4me.controller;

import br.com.tech4me.model.Book;
import br.com.tech4me.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> allBooks(){
        return new ResponseEntity<List<Book>>(service.getAllBooks(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> bookById(@PathVariable String id){
        return new ResponseEntity<Book>(service.getBookById(id), HttpStatus.FOUND);
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
