package test3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import test3.model.Cart;
import test3.model.Product;
import test3.rules.AmountDiscount;
import test3.rules.DiscountRule;
import test3.rules.PercentageDiscount;
import utils.MockData;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void shouldIncludePercentageAndAmountRuleOnDefaultCounter() {
        Counter underTest = new Counter();
        DiscountRule discountRule = underTest.getDiscountRule();

        assertTrue("first rule should be percentage discount rule", discountRule instanceof PercentageDiscount);
        assertTrue("second rule should be amount discount rule", discountRule.getSuccessor() instanceof AmountDiscount);
    }

    @Test
    public void shouldCalculateBillWithSumOfProductsPrice() {
        DiscountRule discountRule = Mockito.mock(DiscountRule.class);
        BigDecimal firstPrice = BigDecimal.valueOf(10);
        BigDecimal secondPrice = BigDecimal.valueOf(15);
        Cart cart = MockData.cartWithQualifiedFor3DiscountCustomer(
                new Product(true, firstPrice),
                new Product(false, secondPrice)
        );
        Counter underTest = new Counter(discountRule);

        underTest.checkout(cart);

        Mockito.verify(discountRule, Mockito.times(1)).calculateBilling(cart, firstPrice.add(secondPrice));
    }
}