package br.com.tech4me.builder;

import br.com.tech4me.model.Rent;

import java.time.LocalDateTime;

public final class RentBuilder {

    public static Rent create(String bookId, LocalDateTime rentDate){
        Rent rent = new Rent();
        rent.setBookId(bookId);
        rent.setRentDate(rentDate);
        return rent;
    }

    public static Rent create(String bookId){
        return create(bookId, LocalDateTime.now());
    }

}
