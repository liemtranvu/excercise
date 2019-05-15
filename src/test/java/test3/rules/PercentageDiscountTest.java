package test3.rules;

import org.junit.Before;
import org.junit.Test;
import test3.model.Cart;
import test3.model.Customer;
import test3.model.Product;
import utils.MockData;

import java.math.BigDecimal;


import static org.junit.Assert.assertEquals;

public class PercentageDiscountTest {

    private PercentageDiscount underTest;

    @Before
    public void setUp() throws Exception {
        this.underTest = new PercentageDiscount();
    }

    @Test
    public void shouldSelectTheOnlyHighestPercentDiscount() {
        Customer customer = MockData.qualifiedFor3DiscountCustomer();
        double expected = PercentageDiscount.DEFAULT_FOR_STAFF;

        double percent = underTest.selectPercent(customer);

        assertEquals("should select highest discount : For staff", expected, percent, 0.01);
    }

    @Test
    public void shouldApply30PercentForStaff() {
        Customer customer = new Customer("mr.staff", true, false,1);
        double expected = PercentageDiscount.DEFAULT_FOR_STAFF;

        double percent = underTest.selectPercent(customer);

        assertEquals("should select 30%", expected, percent, 0.01);
    }

    @Test
    public void shouldApply10PercentForAffiliate() {
        Customer customer = new Customer("mr.staff", false, true,1);
        double expected = PercentageDiscount.DEFAULT_FOR_INFILIATE;

        double percent = underTest.selectPercent(customer);

        assertEquals("should select 10%", expected, percent, 0.01);
    }

    @Test
    public void shouldApply5PercentForLoyalty() {
        Customer customer = new Customer("mr.staff", false, false,3);
        double expected = PercentageDiscount.DEFAULT_FOR_LOYALTY_OVER_2_YEAR;

        double percent = underTest.selectPercent(customer);

        assertEquals("should select 10%", expected, percent, 0.01);
    }

    @Test
    public void shouldExcludeGroceryItems() {
        BigDecimal groceryItemPrice = new BigDecimal(5);
        BigDecimal notGroceryItemPrice = new BigDecimal(10);
        Customer customer = MockData.qualifiedFor3DiscountCustomer();
        Cart cart = new Cart(customer);
        cart.addProduct(new Product(true, groceryItemPrice));
        cart.addProduct(new Product(false, notGroceryItemPrice));
        BigDecimal expected = notGroceryItemPrice.multiply(BigDecimal.valueOf(PercentageDiscount.DEFAULT_FOR_STAFF));

        BigDecimal discount = underTest.calculate(cart, groceryItemPrice.add(notGroceryItemPrice));

        assertEquals("should exclude grocery items when calculate discount"  , expected, discount);
    }


}