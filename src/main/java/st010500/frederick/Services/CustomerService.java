package st010500.frederick.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st010500.frederick.DAO.CustomerRepository;
import st010500.frederick.Models.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bf on 18.01.18.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }


    public Customer getCustomerById(String id)
    {
        return customerRepository.findOne(id);
    }


    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

}
