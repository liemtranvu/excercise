package test3;

import test3.model.Cart;
import test3.model.Product;
import test3.rules.AmountDiscount;
import test3.rules.DiscountRule;
import test3.rules.PercentageDiscount;

import java.math.BigDecimal;

public class Counter {

    private final DiscountRule discountRule;

    public Counter(DiscountRule discountRule) {
        this.discountRule = discountRule;
    }

    public Counter() {
        DiscountRule percentDiscount = new PercentageDiscount();
        DiscountRule amountDiscount = new AmountDiscount();

        percentDiscount.setSuccessor(amountDiscount);

        this.discountRule = percentDiscount;
    }

    public DiscountRule getDiscountRule() {
        return discountRule;
    }

    public BigDecimal checkout(Cart cart) {
        BigDecimal total = new BigDecimal(0);

        for(Product product : cart.getProductList()) {
            total = total.add(product.getPrice());
        }

        return discountRule.calculateBilling(cart, total);
    }
}
