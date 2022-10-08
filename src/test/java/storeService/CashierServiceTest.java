package storeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ola.domain.*;
import org.ola.domain.enums.GENDER;
import org.ola.domain.enums.POSITION;
import org.ola.storeServicesImpl.storeService.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashierServiceTest {
    private CashierService cashierService;
    private Customer customer;
    private Customer customer1;
//    private Product product;
    private List<Product> products;
    private Staff cashier1;
    private Staff cashier2;
    private  String productName = "Carrot";
    private int productQuantity = 201;


    @BeforeEach
    void setUp(){
        customer = new Customer("Obinna");
        customer1 = new Customer("Ola");
        cashier1 = new Staff("Amy", GENDER.FEMALE,"+23456","Asajon",212, POSITION.CASHIER,01);
        cashier2 = new Staff("Amy", GENDER.FEMALE,"+23456","Asajon",212, POSITION.MANAGER,01);
        products = new ArrayList<>();
        cashierService = new CashierService();
        try{
            cashierService.addProductToStore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void getProductIndex() {
        int actual = cashierService.getProductIndex("Carrot");
        int expected = 0;
        assertEquals(expected,actual);

    }
    @Test
    void produceMinusOneForProductNotInStock() {
        int actual = cashierService.getProductIndex("Carro");
        int expected = -1;
        assertEquals(expected,actual);
    }

    @Test
    void sellProductsAndDispenseReceiptForAvailableProduct() {
        String actual = cashierService.sellProductsAndDispenseReceipt(customer,productName,productQuantity);
        String expected = "Thanks for your patronage Obinna you just bought 201 Carrot\n";
        assertEquals(actual,expected);
    }

    @Test
    void returnOutOfStockForProductNotInStore() {
//        Product product = new Product("Bars", productName,productQuantity,1.76);
//        Store.products.add(product);
        String actual = cashierService.sellProductsAndDispenseReceipt(customer,"Oat",productQuantity);
        String expected = "OUT OF STOCK\n";
        assertEquals(actual,expected);
    }

    @Test
    void checkProductAvailabilityInStore() {
//        cashierService.isInStore(productName);
        String actual = String.valueOf(cashierService.isInStore("Carrot"));
        String expected = "true";
        assertEquals(expected, actual);

    }@Test
    void checkProductNotAvailableInStore() {
        String actual = String.valueOf(cashierService.isInStore("Milk"));
        String expected = "false";
        assertEquals(expected, actual);

    }

    @Test
    void checkIfProductIsAvailableAndQuantityDemandedIsAvailable() {
        //Be careful the productQuantity here is checking the entire product quantity in the whole productList
        String actual = String.valueOf(cashierService.ProductIsAvailableAndQuantityDemandedIsAvailable("Carrot", 4220));
        String expected = "true";
        assertEquals(expected, actual);
    }

    @Test
    void ProductIsAvailableButQuantityDemandedIsNotAvailable() {
        //Be careful the productQuantity here is checking the entire product quantity in the whole productList
        String actual = String.valueOf(cashierService.ProductIsAvailableAndQuantityDemandedIsAvailable("Carrot", 5000));
        String expected = String.valueOf(false);
        assertEquals(expected, actual);
    }@Test
    void ProductIsNotAvailableAndQuantityDemandedIsAvailable() {
        //Be careful the productQuantity here is checking the entire product quantity in the whole productList
        String actual = String.valueOf(cashierService.ProductIsAvailableAndQuantityDemandedIsAvailable("Milk", 422));
        String expected = "false";
        assertEquals(expected, actual);
    }
    @Test
    void searchStoreByProductCategory() {
        String actual = cashierService.searchStoreByProductCategory("Bars");
        String expected ="[Bars       Carrot                 4220       1.77, Bars       Bran                   1575       1.87, Bars       Banana                   79       2.27]";
        assertEquals(expected,actual);
    }

    @Test
    void sellToCustomersBasedOnQuantity() {
        Product p1 = Store.getProductList().get(0);
        Product p2 = Store.getProductList().get(1);
        CustomerService customerService1 = new CustomerService(customer);
        CustomerService customerService2 = new CustomerService(customer1);
        customerService1.addToCart(new CustomerProduct(p1, 30));
        customerService2.addToCart(new CustomerProduct(p1, 27));
        List<Customer> customerList = new ArrayList<>(List.of(customer,customer1));
        String actual = cashierService.sellToCustomersBasedOnQuantity(customerList);
        String expected = "Thanks for your patronage Obinna you just bought 30 Carrot\n"+"Thanks for your patronage Ola you just bought 27 Carrot\n";
        assertEquals(expected,actual);
    }
}
