package domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    @Test
    void testAddNewItem() {
        Cart cart = new Cart("C1");
        ProductId productId = new ProductId("P1");

        cart.addItem(productId, 2, new Money(50));

        assertEquals(1, cart.getItems().size());
        assertEquals(100, cart.getTotal().getAmount());
    }

    @Test
    void testAddExistingItemIncreasesQuantity() {
        Cart cart = new Cart("C1");
        ProductId productId = new ProductId("P1");

        cart.addItem(productId, 2, new Money(50));
        cart.addItem(productId, 3, new Money(50));

        assertEquals(1, cart.getItems().size());
        assertEquals(250, cart.getTotal().getAmount());
    }
}
