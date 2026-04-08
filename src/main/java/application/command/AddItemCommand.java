package application.command;

public class AddItemCommand {
    public final String cartId;
    public final String productId;
    public final int quantity;
    public final double price;

    public AddItemCommand(String cartId, String productId, int quantity, double price) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
