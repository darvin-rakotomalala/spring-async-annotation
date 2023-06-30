package com.poc.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;
}
