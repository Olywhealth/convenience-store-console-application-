package org.olaoye.com.storeServicesImpl;

import org.olaoye.com.domian.Customer;
import org.olaoye.com.domian.CustomerProduct;
import org.olaoye.com.domian.Product;
import org.olaoye.com.domian.Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CashierService {
    String productName;
    String productCategory;
    int productQuantity;
    double productPrice;
    String eachLine ="";
    String[] lineContent;





    public int addProductToStore(){
        try {
            String path = "./src/main/resources/sampledatafoodsales.csv";
            FileReader fr = new FileReader(path);
            BufferedReader read = new BufferedReader(fr);
            while((eachLine = read.readLine())!= null){
                lineContent = eachLine.split(",");
                productCategory =lineContent[3];
                productName = lineContent[4];
                productQuantity = Integer.parseInt(lineContent[5]);
                productPrice = Double.parseDouble(lineContent[6]);
               /* checking if the product list from store is empty and the adding new product to it;
               note if the first "if statement" is removed the first element on the list will be omitted*/
                if(Store.getProductList().isEmpty()) {
                  Product product = new Product(productCategory, productName, productQuantity, productPrice);
                    Store.getProductList().add(product);
                }
                //checking if the incoming product is already existing in the list else add a new product to the list
                if(getProductIndex(productName) >= 0){
                    Product oldProduct = Store.getProductList().get(getProductIndex(productName));
                    oldProduct.setProductQuantity(productQuantity + oldProduct.getProductQuantity());
                }
                else {
                    Product product = new Product(productCategory,productName,productQuantity,productPrice);
                    Store.getProductList().add(product);
                }
            }


        }
        catch (FileNotFoundException e){
            System.out.println("No such file or directory");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Store.getProductList().size();
    }
    public int getProductIndex(String productName){
        int index = -1 ;
        List<Product> products = Store.getProductList();
        for (int i=0; i<products.size(); i++) {
            if(Objects.equals(products.get(i).getProductName(), productName)){
                index = i;
            }
        }
        return  index;
    }
    //Method to search for products in the same category using stream.filter
    public String searchStoreByProductCategory(String productCategory) {
        List<Product> products =  Store.getProductList().stream()
                .filter(product -> Objects.equals(product.getProductCategory(), productCategory)).toList();
        if (!products.isEmpty()) {
            return "" + products;
        }
        return "Ooops! You can check back in few weeks";
    }
    public synchronized String sellProductsAndDispenseReceipt(Customer customer, String productName, int productQuantity) {
        AtomicInteger newProductQuantity = null;
            if(isInStore(productName)&&ProductIsAvailableAndQuantityDemandedIsAvailable(productName,productQuantity)){
                for(Product x: Store.getProductList()){
                    if(x.getProductName().equalsIgnoreCase(productName)){
                        newProductQuantity = new AtomicInteger(x.getProductQuantity());
                        newProductQuantity.getAndAdd(-productQuantity);
                        x.setProductQuantity(newProductQuantity.get());

                    }
                }
                System.out.println(newProductQuantity);
                return "Thanks for your patronage "+customer.getName()+" you just bought "+productQuantity+" "+productName+"\n";
            }
            else {
                return "OUT OF STOCK\n";
            }
    }


    public boolean isInStore(String productName){
        boolean state = false;
        for(Product x: Store.getProductList()){
            if (Objects.equals(x.getProductName(), productName)) {
                state = true;
                break;
            }
        }
        return  state;
    }

    public int CustomerProductIndex(Customer customer, String productName){
        int position = -1;
        for (CustomerProduct product: customer.getCart()) {
            if (Objects.equals(product.getProduct().getProductName(), productName)) {
                position =  customer.getCart().indexOf(product);
            }
        }
        return  position;
    }
    public String sellToCustomersBasedOnQuantity(List<Customer> customerList) {
        StringBuilder s = new StringBuilder();
        Store.getProductList().forEach(product ->{
            Comparator<Customer> customersComparator = new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    int customer1Index = CustomerProductIndex(o1,product.getProductName());
                    int customer2Index = CustomerProductIndex(o2,product.getProductName());
                    return Integer.compare(o2.getCart().get(customer2Index).getQuantities(),o1.getCart().get(customer1Index).getQuantities());
                }
            };
            PriorityQueue<Customer> priorityQueue = new PriorityQueue<>(customersComparator);
            for(Customer customer: customerList){
                for (CustomerProduct customerProduct: customer.getCart()) {
                    if (product.getProductName().equals(customerProduct.getProduct().getProductName())) {
                        priorityQueue.add(customer);
                    }
                }
            }
            while (!priorityQueue.isEmpty()) {
                Customer customer = priorityQueue.poll();
                int index = CustomerProductIndex(customer,product.getProductName());
                if (index ==-1) {
                    break;
                }
                String response = sellProductsAndDispenseReceipt(customer, product.getProductName(),customer.getCart().get(index).getQuantities());
                s.append(response);
            }
        });
        return s.toString();
    }


    public boolean ProductIsAvailableAndQuantityDemandedIsAvailable(String productName, int productQuantity){
        boolean state = false;

        for(Product x: Store.getProductList()){
            if (x.getProductQuantity()==0) return state;
            if (Objects.equals(x.getProductName(), productName)) {
                state = x.getProductQuantity() >= productQuantity;
            }
        }

        return state;

    }

}
