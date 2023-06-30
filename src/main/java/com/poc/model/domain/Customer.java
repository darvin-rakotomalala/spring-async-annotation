package com.poc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;
}
