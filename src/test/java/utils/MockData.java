package utils;

import test3.model.Cart;
import test3.model.Customer;
import test3.model.Product;

public class MockData {

    public static Customer qualifiedFor3DiscountCustomer() {
        return new Customer("mr.awesome", true, true, 5);
    }

    public static Cart cartWithQualifiedFor3DiscountCustomer(Product ...products) {
        Cart cart = new Cart(qualifiedFor3DiscountCustomer());

        for(Product product : products) {
            cart.addProduct(product);
        }

        return cart;
    }
}
