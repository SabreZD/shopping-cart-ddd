package domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @Test
    void testMoneyAddition() {
        Money m1 = new Money(50);
        Money m2 = new Money(20);

        Money total = m1.add(m2);

        assertEquals(70, total.getAmount());
    }

    @Test
    void testMoneyMultiply() {
        Money m = new Money(10);
        Money result = m.multiply(4);

        assertEquals(40, result.getAmount());
    }

    @Test
    void testNegativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

}
