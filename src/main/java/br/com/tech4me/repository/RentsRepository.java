package br.com.tech4me.repository;

import br.com.tech4me.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentsRepository extends MongoRepository<Rent, String> { }
