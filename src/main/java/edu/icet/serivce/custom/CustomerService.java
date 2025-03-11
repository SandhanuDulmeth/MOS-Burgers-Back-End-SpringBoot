package edu.icet.serivce.custom;

import edu.icet.Model.Customer;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<Customer> getCustomer() ;


    boolean deleteCustomer(String cusId);


    boolean updateCustomer(Customer customer);
}
