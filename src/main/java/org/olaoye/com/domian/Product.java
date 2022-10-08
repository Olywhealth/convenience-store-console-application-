package org.olaoye.com.domian;

import java.util.Objects;

public class Product{
    private String productCategory;
    private String productName;
    private int productQuantity;
    private double productPrice;

    public Product(String productCategory,String productName, int productQuantity, double productPrice) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-16s %10d %10.2f",productCategory,productName,productQuantity,productPrice) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
