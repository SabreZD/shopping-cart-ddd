package application.handler;

import application.service.CartService;
import application.command.AddItemCommand;
import application.event.ItemAddedEvent;

public class CartCommandHandler {
    private final CartService service;

    public CartCommandHandler(CartService service) {
        this.service = service;
    }

    public ItemAddedEvent handle(AddItemCommand command) {

        service.addItem(
                command.cartId,
                command.productId,
                command.quantity,
                command.price
        );

        // Return event
        return new ItemAddedEvent(
                command.cartId,
                command.productId,
                command.quantity
        );
    }
}
