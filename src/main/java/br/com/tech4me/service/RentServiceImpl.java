package br.com.tech4me.service;

import br.com.tech4me.model.Rent;
import br.com.tech4me.repository.RentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentsRepository repository;

    @Override
    public List<Rent> getAllRents() {
        return repository.findAll();
    }

    @Override
    public Rent addRent(Rent rent) {
        return repository.save(rent);
    }

    @Override
    public void closeRentByBookId(String bookId) {
        closeRent(repository.findAll()
                .stream().filter(rent -> rent.getBookId().equals(bookId))
                .findFirst().orElse(null));
    }

    public void closeRent(Rent rent) {
        if (rent != null) {
            rent.setClosed(true);
            repository.save(rent);
        }
    }

    @Override
    public boolean isRented(String bookId) {
        return repository.findAll()
                .stream().anyMatch(rent -> rent.getBookId().equals(bookId));
    }

    @Override
    public void validateRents() {
        System.out.println("validating...");
        repository.findAll()
                .stream()
                .filter(rent -> Duration.between(rent.getRentDate(), LocalDateTime.now()).getSeconds() > 60 * 2)
                .collect(Collectors.toUnmodifiableList())
                .forEach(this::closeRent);
    }

}
