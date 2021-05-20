package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Book book = new Book(1, "The Old Man and the Sea", 750, "Ernest Hemingway");
    private Smartphone smartphone = new Smartphone(3, "1.1", 20000, "Samsung");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = smartphone.matches(smartphone, "");
        assertEquals(false, actual);
    }

    @Test
    void bookShouldNotMatchesSmartphone() {
        boolean actual = smartphone.matches(book, "Ernest Hemingway");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = smartphone.matches(smartphone, "1.1");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByManufacturer() {
        boolean actual = smartphone.matches(smartphone, "Samsung");
        assertEquals(true, actual);
    }
}
