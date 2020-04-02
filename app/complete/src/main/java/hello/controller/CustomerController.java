package hello.controller;


import hello.model.Customer;
import hello.servce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public List<Customer> hello() {
        return Collections.emptyList();
    }

    //TODO: All logic has to be implemented in service!

    //TODO: Create GET method that retrieves all customers
    public List<Customer> GET() {
        return customerService.getAllCustomers();
    }

    //TODO: Create GET method that gets customer by its ID
    public Customer GET(Long ID) {
        return customerService.getCustomerById(ID);
    }

    //TODO: Create GET method that gets customer by search key (name, surname, etc.)
    public Customer GET(String searchKey) {
        return customerService.getCustomerBySearchKey(searchKey);
    }

    //TODO: Create POST method to saves new customer
    public void POST(Customer customer) {
        customerService.saveCustomer(customer);
    }

    //TODO: Create PUT method to update existing customer. Note! If user tries to update not existing customer, throw an exception
    public void PUT(Customer customer) throws Exception {
        if (customerService.getCustomerById((customer.getId())) == null) {
            throw new Exception("User tries to update not existing customer");
        } else {

            customerService.updateCustomer(customer);

        }
    }



    //TODO: Create DELETE method that deletes customer by id
    public void DELETE(Long id) {
        customerService.deleteCustomerById(id);
    }


    //TODO: Create DELETE method that deletes customer by any other key
  public void DELETE(String key){
        customerService.deleteCustomerByKey(key);
  }
}
