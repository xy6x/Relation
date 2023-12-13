package com.example.relation.controller;

import com.example.relation.Model.Customer;
import com.example.relation.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getAllCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body( customerService.getCustomer());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body("added Customer");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(HttpStatus.OK).body("update Customer");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Customer");

    }
}
