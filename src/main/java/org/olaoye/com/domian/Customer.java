package org.olaoye.com.domian;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<CustomerProduct> cart = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerProduct> getCart() {
        return cart;
    }

    public void setCart(List<CustomerProduct> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer " +
                " name " + name ;
    }
}
