package com.example.redis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Customer")
@Getter
@Setter
@ToString
public class CustomerEntity implements Serializable {

    @Id
    private Long id;
    private String name;
}
