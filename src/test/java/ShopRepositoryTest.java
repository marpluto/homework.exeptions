import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "Хлеб", 50);
    Product product2 = new Product(2, "Молоко", 65);
    Product product3 = new Product(3, "Пельмени", 299);
    ShopRepository repository = new ShopRepository();

    @Test
    public void removeByIdPositiveTest() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.removeById(1);

        Product[] expected = {product2, product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNegativeTest() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }
}
