package org.olaoye.com.domian;

public class CustomerProduct {
    private Product product;
    private int quantities;

    public CustomerProduct(Product product, int quantities) {
        this.product = product;
        this.quantities = quantities;
    }

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public int getQuantities() {return quantities;}

    public void setQuantities(int quantities) {this.quantities = quantities;}

    @Override
    public String toString() {
        return "CustomerProduct: " + product +
                " quantities: " + quantities ;
    }
}
