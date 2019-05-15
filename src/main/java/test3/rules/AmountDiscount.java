package test3.rules;

import test3.model.Cart;

import java.math.BigDecimal;

public class AmountDiscount extends DiscountRule {

    public static final BigDecimal DEFAULT_DISCOUNT_PER_100_USD = new BigDecimal(5);

    private final BigDecimal discountPer100USD;

    public AmountDiscount(BigDecimal discountPer100USD) {
        this.discountPer100USD = discountPer100USD;
    }

    public AmountDiscount() {
        this(DEFAULT_DISCOUNT_PER_100_USD);
    }

    @Override
    protected BigDecimal calculate(final Cart cart, final BigDecimal total) {
        return total.divide(BigDecimal.valueOf(100), BigDecimal.ROUND_DOWN).multiply(discountPer100USD);
    }
}
