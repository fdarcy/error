import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveCorrectlyIfHasProduct() {
        ShopRepository repo = new ShopRepository();

        Product milk = new Product(1, "Простоквашино", 100);
        Product butter = new Product(2, "Простоквашино", 125);
        Product book = new Product(3, "Каникулы в Простоквашино", 300);

        repo.add(milk);
        repo.add(butter);
        repo.add(book);

        repo.remove(3);

        Product[] expected = {milk, butter};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowCorrectExceptionIfHasNotProduct() {
        ShopRepository repo = new ShopRepository();

        Product milk = new Product(1, "Простоквашино", 100);
        Product butter = new Product(2, "Простоквашино", 125);
        Product book = new Product(3, "Каникулы в Простоквашино", 300);

        repo.add(milk);
        repo.add(butter);
        repo.add(book);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });
    }
}
