package net.outsila.customerservice;

import net.outsila.customerservice.entities.Customer;
import net.outsila.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
   private  CustomerRepository customerepository;

    public List<Customer> getAllCustomers() {
       return  customerepository.findAll();
    }

   public Customer findCustomerById(Long id) {
        return customerepository.getReferenceById(id);
   }

   public Customer saveCustomer(Customer customer) {
         return customerepository.save(customer);
   }

}
