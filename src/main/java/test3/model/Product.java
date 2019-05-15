package test3.model;

import java.math.BigDecimal;

public class Product {

    private boolean grocery;
    private BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price;
    }

    public Product(boolean grocery, BigDecimal price) {
        this.grocery = grocery;
        this.price = price;
    }

    public boolean isGrocery() {
        return grocery;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

