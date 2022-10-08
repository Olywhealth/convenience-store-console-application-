package org.olaoye.com.domian;

import org.olaoye.com.domian.enums.GENDER;
import org.olaoye.com.domian.enums.POSITION;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private String storeName = "Olachem";
    private Staff manager;
//    private List<Customer> customerList = new ArrayList<>();
    private static List<Staff> cashiers = new ArrayList<>(); //complain when I remove "Static"
    private static List<Product> productList = new ArrayList<>();
    // setting getters and setters for the private fields


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public static List<Staff> getCashiers() {
        return cashiers;
    }

    public static void setCashiers(List<Staff> cashiers) {
        Store.cashiers = cashiers;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    //constructor for creating store
    public Store(String storeName){
        this.storeName = storeName;
        manager = new Staff("Olaoye", GENDER.MALE, "+2347012345", "6, Ajegunle", 001, 12, POSITION.MANAGER);
    }
}
