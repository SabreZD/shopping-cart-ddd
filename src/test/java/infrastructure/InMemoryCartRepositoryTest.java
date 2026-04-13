package infrastructure;

import domain.model.Cart;
import domain.repository.CartRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InMemoryCartRepositoryTest {
    @Test
    void testSaveAndFind() {
        CartRepository repo = new InMemoryCartRepository();
        Cart cart = new Cart("C1-2");

        repo.save(cart);

        Cart retrieved = repo.findById("C1-2");
        assertNotNull(retrieved);
        assertEquals("C1-2", retrieved.getId());
    }
}
