package hello.servce;

import hello.mapper.CustomerMapper;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //TODO: Implement methods for each controller method. Note that each of them has to call different method from Service.


    public Customer getCustomerById(Long id) {
        if(customerRepository.existsById(id)){
        return customerRepository.findCustomerById(id);}
        else return null;
    }

    public Customer getCustomerBySearchKey(String searchKey){
        return customerRepository.findCustomerBy(searchKey);
    }
    public void saveCustomer(Customer customer){
       // CustomerMapper customerMapper = new CustomerMapper();
        customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer)
    {
        customerRepository.update(customer);
    }

    public void deleteCustomerById(Long id)
    {
        customerRepository.deleteById(id);
    }

    public void deleteCustomerByKey(String key)
    {
        Customer customer = customerRepository.findCustomerBy(key);
        if(customerRepository.findCustomerBy(key)!=null) {customerRepository.delete(customer);};
    }



}
