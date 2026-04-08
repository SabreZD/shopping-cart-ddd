package domain.model;

public class Money {
    private final double amount;

    public Money(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money multiply(int quantity) {
        return new Money(this.amount * quantity);
    }
}
