package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;


    public Book() {

        super();
    }

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;


    }

    public String getAuthor() {
        return author;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +

                '}';
    }
}