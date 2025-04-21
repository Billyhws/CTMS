package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Customer;
import com.ctms.ctms.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomerHandler(@PathVariable("id") Long id) {
        String response = customerService.deleteCustomer(id);
        if (response.equals("Not Found")) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomersHandler() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomerHandler(@RequestBody() Customer customer, @PathVariable("id") Long id) {
        if (!customer.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.updateCustomer(customer,id), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerHandler(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}
