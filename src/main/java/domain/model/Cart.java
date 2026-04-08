package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private final String id;
    private final List<CartItem> items = new ArrayList<>();

    public Cart(String id) {
        this.id = id;
    }

    public void addItem(ProductId productId, int quantity, Money price) {

        Optional<CartItem> existing =
                items.stream()
                        .filter(i -> i.getProductId().getId().equals(productId.getId()))
                        .findFirst();

        if (existing.isPresent()) {
            existing.get().increaseQuantity(quantity);
        } else {
            items.add(new CartItem(productId, quantity, price));
        }
    }

    public Money getTotal() {
        Money total = new Money(0);
        for (CartItem item : items) {
            total = total.add(item.getTotal());
        }
        return total;
    }

    public String getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

}
