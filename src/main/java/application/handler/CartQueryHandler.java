package application.handler;

import application.service.CartService;
import application.query.GetCartTotalQuery;

public class CartQueryHandler {
    private final CartService service;

    public CartQueryHandler(CartService service) {
        this.service = service;
    }

    public double handle(GetCartTotalQuery query) {
        return service.getTotal(query.cartId);
    }
}
