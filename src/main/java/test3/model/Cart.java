package test3.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final Customer customer;
    private List<Product> productList;


    public Cart(Customer customer) {
        this.customer = customer;
        productList = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public boolean addProduct(Product product) {
        return productList.add(product);
    }
}
