package test3.rules;

import org.junit.Before;
import org.junit.Test;
import test3.model.Cart;
import utils.MockData;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AmountDiscountTest {

    private AmountDiscount underTest;

    @Before
    public void setUp() throws Exception {
        this.underTest = new AmountDiscount();
    }

    @Test
    public void shouldRoundDownForDiscount() {
        BigDecimal total = new BigDecimal(250);
        BigDecimal expected = AmountDiscount.DEFAULT_DISCOUNT_PER_100_USD.multiply(BigDecimal.valueOf(2));
        Cart cart = new Cart(MockData.qualifiedFor3DiscountCustomer());

        BigDecimal result = underTest.calculate(cart, total);

        assertEquals("should round down", expected, result);
    }
}