package test3.rules;

import test3.model.Cart;

import java.math.BigDecimal;

public abstract class DiscountRule {

    protected DiscountRule successor;

    public void setSuccessor(DiscountRule successor) {
        this.successor = successor;
    }

    public BigDecimal calculateBilling(final Cart cart, final BigDecimal total){
        BigDecimal discount = calculate(cart, total);
        if(successor != null) {
            discount = this.successor.calculate(cart, total.subtract(discount));
        }
        return total.subtract(discount);
    }

    protected abstract BigDecimal calculate(final Cart cart, final BigDecimal total);

}
