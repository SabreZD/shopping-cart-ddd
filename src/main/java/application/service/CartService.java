package application.service;

import domain.model.Cart;
import domain.model.Money;
import domain.model.ProductId;
import domain.repository.CartRepository;

public class CartService {
    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public void addItem(String cartId, String productId, int quantity, double price) {

        Cart cart = repository.findById(cartId);

        cart.addItem(
                new ProductId(productId),
                quantity,
                new Money(price)
        );

        repository.save(cart);
    }

    public double getTotal(String cartId) {
        return repository.findById(cartId)
                .getTotal()
                .getAmount();
    }
}
