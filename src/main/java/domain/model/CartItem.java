package domain.model;

public class CartItem {
    private final ProductId productId;
    private int quantity;
    private Money price;

    public CartItem(ProductId productId, int quantity, Money price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public void increaseQuantity(int qty) {
        this.quantity += qty;
    }

    public Money getTotal() {
        return price.multiply(quantity);
    }

    public ProductId getProductId() {
        return productId;
    }
}
