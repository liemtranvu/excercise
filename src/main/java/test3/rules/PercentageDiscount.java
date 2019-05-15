package test3.rules;

import test3.model.Cart;
import test3.model.Customer;
import test3.model.Product;

import java.math.BigDecimal;

public class PercentageDiscount extends DiscountRule {

    public static final double DEFAULT_FOR_STAFF = 0.3;
    public static final double DEFAULT_FOR_INFILIATE = 0.1;
    public static final double DEFAULT_FOR_LOYALTY_OVER_2_YEAR = 0.05;

    private final double forStaff;
    private final double forAnfiliate;
    private final double forLoyalty;

    public PercentageDiscount(double forStaff, double forAnfiliate, double forLoyalty) {
        this.forStaff = forStaff;
        this.forAnfiliate = forAnfiliate;
        this.forLoyalty = forLoyalty;
    }

    public PercentageDiscount() {
        this(DEFAULT_FOR_STAFF, DEFAULT_FOR_INFILIATE, DEFAULT_FOR_LOYALTY_OVER_2_YEAR);
    }

    protected double selectPercent(Customer customer) {
        if(customer.isStaff()) {
            return forStaff;
        }

        if(customer.isAffiliate()) {
            return forAnfiliate;
        }

        if(customer.getYearOfLoyalty() > 2) {
            return forLoyalty;
        }

        return 0.0;
    }

    @Override
    protected BigDecimal calculate(final Cart cart, final BigDecimal total) {
        double percent = selectPercent(cart.getCustomer());
        BigDecimal groceryTotal = new BigDecimal(0);

        for(Product product: cart.getProductList()) {
            if(product.isGrocery()) {
                groceryTotal = groceryTotal.add(product.getPrice());
            }
        }


        return total.subtract(groceryTotal).multiply(BigDecimal.valueOf(percent));
    }
}
