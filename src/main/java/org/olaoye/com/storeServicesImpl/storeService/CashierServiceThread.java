package org.olaoye.com.storeServicesImpl.storeService;

import org.olaoye.com.domian.Customer;
import org.olaoye.com.domian.Product;
import org.olaoye.com.storeServicesImpl.CashierService;

public class CashierServiceThread extends Thread{
    private CashierService cashierService;
    private Customer customer;
    private Product product;

    public CashierServiceThread (CashierService cashierService, Customer customer, Product product){
        this.cashierService = cashierService;
        this.customer = customer;
        this.product = product;
    }

    @Override
    public void run() {
        try{

        System.out.println(this.cashierService.sellProductsAndDispenseReceipt(this.customer, this.product.getProductName(),
                this.product.getProductQuantity()));
            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
