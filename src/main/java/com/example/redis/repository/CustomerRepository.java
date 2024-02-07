package com.example.redis.repository;

import com.example.redis.entity.CustomerEntity;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableRedisRepositories
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {

}
