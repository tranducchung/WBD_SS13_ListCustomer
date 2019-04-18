package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerServicempl implements CustomerService {

    private static Map<Integer,Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"John","john@codegym.vn","Hanoi"));
        customers.put(2,new Customer(2,"Bill","bill@codegym.vn","Danang"));
        customers.put(3,new Customer(3,"Alex","alex@codegym.vn","Saigon"));

    }

    @Override
    public ArrayList findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
       return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
    customers.replace(id,customer);
    }

    @Override
    public void remove(int id) {
    customers.remove(id);
    }

    public static Map<Integer, Customer> getCustomers() {
        return customers;
    }
}
