package edu.icet.controller;

import edu.icet.Model.Customer;
import edu.icet.serivce.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@CrossOrigin
@RequestMapping("/customerController")
@RequiredArgsConstructor
public class CustomerController {


    final CustomerService customerService;

    @GetMapping("/get-Customers")
    public ResponseEntity<ArrayList<Customer>> getCustomer() {
        ArrayList<Customer> items = customerService.getCustomer();
        if (!items.isEmpty()) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("add-Customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        if(customerService.addCustomer(customer)){
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.badRequest().body("false");
        }
    }

    @DeleteMapping("/delete-Customers/{itemId}")
    public ResponseEntity<String> addCustomer(@PathVariable String itemId) {
        if (customerService.deleteCustomer(itemId)) {
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.badRequest().body("false");
        }
    }

    @PatchMapping("/update-Customers")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        System.out.println("this works");
        if(customerService.updateCustomer(customer)){
            return ResponseEntity.ok("true");
        }else{
            return ResponseEntity.badRequest().body("false");
        }
    }
}
