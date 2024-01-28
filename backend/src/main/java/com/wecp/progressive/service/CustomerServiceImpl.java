
package com.wecp.progressive.service;


//import com.wecp.progressive.dao.CustomerDAO;
//import com.wecp.progressive.dao.CustomerDAOImpl;
import com.wecp.progressive.entity.Customers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService {


    private static List<Customers> customersList = new ArrayList<>();


    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customersList;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        for(Customers a: customersList){
            if(a.getCustomerId()==customerId){
                return a;
            }
     }
          return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        if(customers.getCustomerId()!=0)    
       { customersList.add(customers);
        return customers.getCustomerId();}
        else{
        return 0;}    
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
         for(Customers c:customersList){
            if(c.getCustomerId()==customers.getCustomerId()){
                c.setCustomerId(customers.getCustomerId());
                c.setEmail(customers.getEmail());
                c.setName(customers.getName());
                c.setPassword(customers.getPassword());
                c.setUsername(customers.getUsername());
                c.setRole(customers.getRole());
            }
         }
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
           for(Customers c:customersList){
            if(c.getCustomerId()==customerId){
                customersList.remove(c);
            }
           }
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> sortedCustomers = customersList;
        if (sortedCustomers != null) {
            Collections.sort(sortedCustomers);
        }
        return sortedCustomers;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        return customersList;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        customersList.add(customers);
        return customersList;
    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList(){
        List<Customers> sortedCustomers = customersList;
        Collections.sort(sortedCustomers);
        return sortedCustomers;
    }

    @Override
    public void emptyArrayList() {
        customersList = new ArrayList<>();
    }
}