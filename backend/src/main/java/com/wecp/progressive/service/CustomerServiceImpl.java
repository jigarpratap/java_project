package com.wecp.progressive.service;

import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.entity.Customers;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static List<Customers> list = new ArrayList<>();

    private CustomerDAO c;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.c = customerDAO;
    }
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        return -1;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {

    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        return null;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        return list;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        list.add(customers);
        return list;
    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList(){
        List<Customers> sortList=list;
        Collections.sort(sortList);
        return sortList;
    }

    @Override
    public void emptyArrayList() {
        list=new ArrayList<>();
    }
}