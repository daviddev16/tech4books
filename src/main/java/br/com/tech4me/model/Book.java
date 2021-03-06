package br.com.tech4me.model;

import org.springframework.data.annotation.Id;

public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private Float price;
    private Float totalPages;

    public Book() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Float totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", totalPages=" + totalPages +
                '}';
    }
}
