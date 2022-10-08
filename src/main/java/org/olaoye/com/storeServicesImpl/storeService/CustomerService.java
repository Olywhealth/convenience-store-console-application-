package org.olaoye.com.storeServicesImpl.storeService;


import org.olaoye.com.domian.Customer;
import org.olaoye.com.domian.CustomerProduct;

public class CustomerService {
    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

   public String addToCart(CustomerProduct customerProduct){
        if(customerProduct.getQuantities()<=0)
            return "Product quantity can not be less than one";
        customer.getCart().add(customerProduct);
        return customerProduct.getProduct().getProductName()+" "+customerProduct.getQuantities()+" added to cart";

   }

}
