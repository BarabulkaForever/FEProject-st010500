package st010500.frederick.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import st010500.frederick.Models.Customer;
import st010500.frederick.Services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bf on 17.01.18.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable String id)
    {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
    }
}
