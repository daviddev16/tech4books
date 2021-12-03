package br.com.tech4me.repository;

import br.com.tech4me.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Book, String> { }
