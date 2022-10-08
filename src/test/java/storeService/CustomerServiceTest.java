package storeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ola.domain.*;
import org.ola.storeServicesImpl.CashierService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerServiceTest {

    @BeforeEach
    void setUp(){

        CashierService cashierService = new CashierService();
        try{
            cashierService.addProductToStore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    void rejectQuantityLessThanOne() {
        Product p1 = Store.getProductList().get(0);
        Customer customer = new Customer("Obinna");
        CustomerService customerService = new CustomerService(customer);
        String actual = customerService.addToCart(new CustomerProduct(p1, 0));;
        String expected = "Product quantity can not be less than one";
        assertEquals(expected,actual);
    }

}