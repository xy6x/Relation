package com.example.relation.Service;

import com.example.relation.Model.Customer;
import com.example.relation.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer){
         customerRepository.save(customer);
    }
    public void updateCustomer( Integer id,  Customer customer){
        Customer customers=customerRepository.findCustomerById(id);

         customerRepository.save(customers);
    }
    public void deleteCustomer(Integer id){

        Customer customer=customerRepository.findCustomerById(id);
         customerRepository.delete(customer);

    }


}
