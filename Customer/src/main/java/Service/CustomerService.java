package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    ArrayList findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id,Customer customer);
    void remove(int id);
}
