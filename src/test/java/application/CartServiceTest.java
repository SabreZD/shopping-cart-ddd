package application;

import application.service.CartService;
import domain.factory.CartFactory;
import domain.model.Cart;
import domain.repository.CartRepository;
import infrastructure.InMemoryCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartServiceTest {
    private CartRepository repo;
    private CartService service;
    private Cart cart;

    @BeforeEach
    void setup() {
        repo = new InMemoryCartRepository();
        service = new CartService(repo);

        CartFactory factory = new CartFactory();
        cart = factory.createCart();
        repo.save(cart);
    }

    @Test
    void testAddItemToCart() {
        service.addItem(cart.getId(), "P1", 2, 50);
        assertEquals(100, service.getTotal(cart.getId()));
    }

    @Test
    void testAddMultipleItems() {
        service.addItem(cart.getId(), "P1", 1, 50);
        service.addItem(cart.getId(), "P2", 3, 30);

        assertEquals(145, service.getTotal(cart.getId()));
    }
}
