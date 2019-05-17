package test3.rules;

import test3.model.Cart;

import java.math.BigDecimal;

public abstract class DiscountRule {

    protected DiscountRule successor;

    public void setSuccessor(DiscountRule successor) {
        this.successor = successor;
    }

    public DiscountRule getSuccessor() {
        return successor;
    }

    public BigDecimal calculateBilling(final Cart cart, final BigDecimal total){
        BigDecimal discount = calculate(cart, total);
        BigDecimal billing = total.subtract(discount);
        if(successor != null) {
            return this.successor.calculateBilling(cart, billing);
        }
        return billing;
    }

    protected abstract BigDecimal calculate(final Cart cart, final BigDecimal total);

}
