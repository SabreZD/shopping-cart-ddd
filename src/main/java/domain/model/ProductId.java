package domain.model;

public class ProductId {
    private final String id;

    public ProductId(String id) {
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Invalid product ID");
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
