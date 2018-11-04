package com.zzw.entity;

public class Title {

    private Integer id;

    private String author;

    private Integer borrowedNumber;

    private String isbn;

    private String name;

    private Double price;

    private Integer totalNumber;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(Integer borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", borrowedNumber=" + borrowedNumber +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalNumber=" + totalNumber +
                ", type='" + type + '\'' +
                '}' +
                '\n';
    }
}
