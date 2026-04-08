package domain.factory;

import domain.model.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartFactoryTest {
    @Test
    void testCartCreation() {
        CartFactory factory = new CartFactory();
        Cart cart = factory.createCart();

        assertNotNull(cart.getId());
        assertTrue(cart.getItems().isEmpty());
    }
}
