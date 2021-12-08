package br.com.tech4me.service;

import br.com.tech4me.model.Rent;

import java.util.List;

public interface RentService {

    List<Rent> getAllRents();

    Rent addRent(Rent rent);

    void closeRentByBookId(String bookId);

    void closeRent(Rent rent);

    boolean isRented(String bookId);

    void validateRents();

}
