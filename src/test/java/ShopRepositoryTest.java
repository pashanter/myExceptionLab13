import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "1", 1);
    Product product2 = new Product(2, "2", 2);
    Product product3 = new Product(3, "3", 3);


    @Test
    public void TestWhenIdWasFound() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product [] expected = {product1, product3};
        Product [] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void TestWhenIdWasNotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(55));
    }
}
