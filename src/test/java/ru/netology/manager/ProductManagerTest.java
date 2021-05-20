package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "The Old Man and the Sea", 750, "Ernest Hemingway");
    private Book secondBook = new Book(2, "The Sun also Rises", 500, "Ernest Hemingway");
    private Smartphone firstSmartphone = new Smartphone(3, "1.1", 20000, "Samsung");
    private Smartphone secondSmartphone = new Smartphone(4, "2.2", 15000, "Samsung");
    private TShirt tShirt = new TShirt(5, "A", 950, "B");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(tShirt);
    }



    @Test
    public void shouldFindSeveralByBookAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = manager.searchBy("Ernest Hemingway");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("The Old Man and the Sea");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("2.2");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFind() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Do not worry");
        assertArrayEquals(expected, actual);
    }
}
