package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class CustomerController {
      @Autowired
       private CustomerServiceImpl customerServiceImpl;
    @GetMapping("/customers")   
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return new ResponseEntity<List<Customers>>(customerServiceImpl.getAllCustomers(), HttpStatus.OK);
    }
    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customers> getCustomerById(int customerId) throws SQLException {
          Customers c=customerServiceImpl.getCustomerById(customerId);
          if(c!=null){
            return new ResponseEntity<>(HttpStatus.OK);
          }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }
   @PostMapping("/customers")
    public ResponseEntity<Integer> addCustomer(Customers customers) throws SQLException {
          
           return new ResponseEntity<Integer>(customerServiceImpl.addCustomer(customers), HttpStatus.OK);
    }
   @PutMapping("customers")
    public ResponseEntity<Void> updateCustomer(int customerId, Customers customers) throws SQLException {
         customerServiceImpl.updateCustomer(customers);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("customers/{customerID}")
    public ResponseEntity<Void> deleteCustomer(int customerId) throws SQLException {
        customerServiceImpl.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
        return null;
    }
}
