package br.com.tech4me.view.model;

public class BookResponse {

    private String id;
    private String name;
    private String author;
    private Float totalPages;

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

    public Float getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Float totalPages) {
        this.totalPages = totalPages;
    }
}
