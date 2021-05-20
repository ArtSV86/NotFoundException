package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "The Old Man and the Sea", 750, "Ernest Hemingway");
    private Book secondBook = new Book(2, "The Sun also Rises", 500, "Ernest Hemingway");
    private Smartphone firstSmartphone = new Smartphone(3, "1.1", 20000, "Samsung");
    private Smartphone secondSmartphone = new Smartphone(4, "2.2", 15000, "Samsung");
    private TShirt tShirt = new TShirt(5, "A", 950, "B");


    @Test
    public void shouldRemoveByID() {
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFoundException() {
//        Product[] expected = new Product[]{firstBook};
//        Product[] actual = repository.removeById(6);
//        assertArrayEquals(expected, actual);
        assertThrows(NotFoundException.class, () -> repository.removeById(8));
    }

}
