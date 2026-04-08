package application.event;

public class ItemAddedEvent {
    public final String cartId;
    public final String productId;
    public final int quantity;

    public ItemAddedEvent(String cartId, String productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
