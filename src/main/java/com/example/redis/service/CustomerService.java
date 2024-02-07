package com.example.redis.service;

import com.example.redis.dto.CustomerRequestDto;
import com.example.redis.dto.CustomerResponseDto;
import com.example.redis.entity.CustomerEntity;
import com.example.redis.mapper.CustomerMapper;
import com.example.redis.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponseDto> getAll() {
        Iterable<CustomerEntity> all1 = customerRepository.findAll();
        return customerMapper.mapEntityListToResponseList(all1);
    }

    public String create(CustomerRequestDto customerRequestDto){
        CustomerEntity customerEntity = customerMapper.mapRequestDtoToEntity(customerRequestDto);
        customerRepository.save(customerEntity);
        return "Created Successfully";
    }

    public String delete(Long id){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerEntity);
        return "Deleted Successfully";
    }

    public String update(Long id, CustomerRequestDto customerRequestDto){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
        customerMapper.update(customerEntity, customerRequestDto);
        customerRepository.save(customerEntity);
        return "Updated Successfully";
    }
}
