package br.com.tech4me.controller;

import br.com.tech4me.builder.RentBuilder;
import br.com.tech4me.model.Book;
import br.com.tech4me.model.Rent;
import br.com.tech4me.service.BookService;
import br.com.tech4me.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rents")
public class RentController {

    @Autowired
    private RentService rentService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Rent>> allRents() {
        return new ResponseEntity<List<Rent>>(rentService.getAllRents(), HttpStatus.FOUND);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<Rent> rentBook(@PathVariable String bookId) {

        if (!bookService.getBookById(bookId).isPresent())
            return new ResponseEntity<Rent>(HttpStatus.NOT_FOUND);

        Rent rent = rentService.addRent(RentBuilder.create(bookId));
        return new ResponseEntity<Rent>(rent, HttpStatus.CREATED);

    }

    @PostMapping("/close/{bookId}")
    public ResponseEntity<Void> closeRent(@PathVariable String bookId) {

        if (!bookService.getBookById(bookId).isPresent() || !rentService.isRented(bookId))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        rentService.closeRentByBookId(bookId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
