package test3.rules;

import org.junit.Test;
import org.mockito.Mockito;
import test3.model.Cart;
import utils.MockData;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;



public class DiscountRuleTest {

    @Test
    public void shouldCallSuccessorOnRuleChainWithTotalSubtractCalculatedCount() {
        DiscountRule amountRule = new AmountDiscount();
        DiscountRule mockRule = mock(DiscountRule.class);
        BigDecimal total = BigDecimal.valueOf(100);
        BigDecimal discount = BigDecimal.valueOf(5);
        BigDecimal mockDiscount = BigDecimal.valueOf(10);
        Cart cart = new Cart(MockData.qualifiedFor3DiscountCustomer());

        amountRule.setSuccessor(mockRule);
        when(mockRule.calculate(cart, total.subtract(discount))).thenReturn(mockDiscount);
        amountRule.calculateBilling(cart, total);

        Mockito.verify(mockRule, Mockito.times(1)).calculate(eq(cart), any(BigDecimal.class));
        Mockito.verifyNoMoreInteractions(mockRule);
    }

}