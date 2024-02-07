package com.example.redis.controller;

import com.example.redis.dto.CustomerRequestDto;
import com.example.redis.dto.CustomerResponseDto;
import com.example.redis.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CustomerResponseDto>> getAll( ) {
        List<CustomerResponseDto> all = customerService.getAll();
        return  ResponseEntity.ok(all);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CustomerRequestDto customerRequestDto){
        customerService.create(customerRequestDto);
        return ResponseEntity.ok("Comment created succesfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.ok("Comment deleted Successfully!");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CustomerRequestDto commentRequestDto){
        customerService.update(id, commentRequestDto);
        return ResponseEntity.ok("Comment updated Successfully!");

    }
}
