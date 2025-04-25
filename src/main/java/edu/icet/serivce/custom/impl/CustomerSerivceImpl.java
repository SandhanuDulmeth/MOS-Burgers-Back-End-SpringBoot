package edu.icet.serivce.custom.impl;

import edu.icet.Model.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.ItemEntity;
import edu.icet.repository.custom.CustomerRepository;
import edu.icet.serivce.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Primary
@RequiredArgsConstructor
public class CustomerSerivceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public ArrayList<Customer> getCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        if(customerRepository.gettAll()!=null){
        customerRepository.gettAll().forEach(customerEntity  -> customers.add(mapper.map(customerEntity, Customer.class)));
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(String cusId) {
        return customerRepository.delete(cusId);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.update(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.save(mapper.map(customer, CustomerEntity.class));
    }
}
