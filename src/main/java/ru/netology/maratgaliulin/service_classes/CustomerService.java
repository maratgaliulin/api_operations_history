package ru.netology.maratgaliulin.service_classes;
import ru.netology.maratgaliulin.customer_classes.Customer;
import java.util.ArrayList;
import java.util.List;
import static ru.netology.maratgaliulin.service_classes.IOService.InputCustomerCredentials;



public class CustomerService {
    public static Customer MakeSingleCustomer(List<String> arrayList){
        Customer customer = new Customer();
        customer.setLastName(arrayList.get(0));
        customer.setFirstName(arrayList.get(1));
        customer.setEmail(arrayList.get(2));
        customer.setPhoneNo(arrayList.get(3));
        customer.setDOB(arrayList.get(4));

        return customer;

    }
    public static List<Customer> MakeCustomerList(int customerArrLen){
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < customerArrLen; i ++){
            customers.add(MakeSingleCustomer(InputCustomerCredentials()));
        }

        return customers;
    }
    public static List<String> getCustomerIds(List<Customer> customers){

        List<String> CustomerIds = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerIds.add(customer.getClientID());
        }

        return CustomerIds;
    }
    public static Customer getCustomerById(List<Customer> customers, String customerID){

        for (Customer customer : customers){
            if (customer.getClientID().equals(customerID)){
                return customer;
            }
        }
        return null;
    }


}
