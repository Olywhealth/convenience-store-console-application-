package org.olaoye.com.storeServicesImpl;

import org.olaoye.com.domian.*;
import org.olaoye.com.domian.enums.GENDER;
import org.olaoye.com.domian.enums.POSITION;
import org.olaoye.com.storeServicesImpl.storeService.CashierServiceThread;
import org.olaoye.com.storeServicesImpl.storeService.CustomerService;

public class MyStore {
    public static void main(String[] args) {
        Store store = new Store("XYZ");
        Staff realManager = new Staff("manager", GENDER.MALE,"081","Sangotedo",001,001, POSITION.MANAGER);
        Staff fakeManager = new Staff("manager", GENDER.MALE,"081","Sangotedo",001,001, POSITION.CASHIER);
        Staff newCashier = new Staff("Akinbo", GENDER.FEMALE,"081","Sangotedo",001,POSITION.CASHIER,9);
        CashierService cashierService = new CashierService();
        Customer firsCustomer = new Customer("Adebayo");
        Customer secondCustomer = new Customer("Adeyinka");
        Customer thirdCustomer = new Customer("Titilayo");
        Customer fourthCustomer = new Customer("Tosin");
        Product carrot = new Product("Bars","Carrot", 3000,1.77);
//        Product bran = new Product("Bars","Bran", 10,1.87);
//        Product banana = new Product("Bars","Banana", 19,2.27);


        ManagerServiceImpl managerService = new ManagerServiceImpl();
        cashierService.addProductToStore();

        CustomerService customerService1 = new CustomerService(firsCustomer);
        CustomerService customerService2 = new CustomerService(secondCustomer);
        CustomerService customerService3 = new CustomerService(thirdCustomer);

        Product p1 = Store.getProductList().get(0);
        Product p2 = Store.getProductList().get(1);
        Product p3 = Store.getProductList().get(2);

        customerService1.addToCart(new CustomerProduct(p1,32));
        customerService2.addToCart(new CustomerProduct(p2,35));
        customerService1.addToCart(new CustomerProduct(p2,38));

//        List<Customer> customerList = new ArrayList<>(List.of(secondCustomer,firsCustomer));
//        System.out.println(cashierService.sellToCustomersBasedOnQuantity(customerList));
//        System.out.println(cashierService.sellProductsAndDispenseReceipt(firsCustomer, "Carrot", 4000));
//        System.out.printf("%-10s %-16s %-10s %-10s","Category","Product","Quantity","UnitPrice($g)\n..................................................\n");
//        Store.getProductList().forEach(System.out::println);
//        firsCustomer.getCart().forEach(System.out::println);


//
//        System.out.println(managerService.hireACashier(newCashier, realManager)+"\n");
//        String result = cashierService.addOrSellProduct(newCashier, g1, firsCustomer, store);

        CashierServiceThread ct2 = new CashierServiceThread(cashierService,secondCustomer, carrot);
        CashierServiceThread ct1 = new CashierServiceThread(cashierService,firsCustomer, carrot);
        ct1.start();
        ct2.start();
        System.out.println(cashierService.searchStoreByProductCategory("Bars"));

    }
}
