package infrastructure;

import domain.model.Cart;
import domain.repository.CartRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCartRepository implements CartRepository {

    private final Map<String, Cart> storage = new HashMap<>();

    @Override
    public void save(Cart cart) {
        storage.put(cart.getId(), cart);
    }

    @Override
    public Cart findById(String id) {
        return storage.get(id);
    }
}
