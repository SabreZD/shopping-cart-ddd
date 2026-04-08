package domain.repository;

import domain.model.Cart;

public interface CartRepository {
    void save(Cart cart);
    Cart findById(String id);
}
