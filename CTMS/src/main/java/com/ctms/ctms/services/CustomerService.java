package com.ctms.ctms.services;

import com.ctms.ctms.exception.CustomerNotFoundException;
import com.ctms.ctms.models.Customer;
import com.ctms.ctms.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long id) {

        Customer customer1 = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer1.setPassword(customer.getPassword());
        customer1.setEmail(customer.getEmail());
        customer1.setFirstname(customer.getFirstname());
        customer1.setLastname(customer.getLastname());
        customer1.setPhone(customer.getPhone());

        return customerRepo.save(customer1);

    }

    public String deleteCustomer(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
        customerRepo.delete(customer);
        return "Customer deleted successfully.";
    }

    public List<Customer> getAllCustomers() {
        List<Customer> agency = customerRepo.findAll();

        if (agency.isEmpty()) {
            throw new CustomerNotFoundException("No customer found.");
        }

        return agency;
    }

    public  Customer getCustomerById(Long id){
        return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Agency not found"));
    }

}
