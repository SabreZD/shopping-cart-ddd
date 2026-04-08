package domain.factory;

import domain.model.Cart;

import java.util.UUID;

public class CartFactory {
    public Cart createCart() {
        return new Cart(UUID.randomUUID().toString());
    }
}
