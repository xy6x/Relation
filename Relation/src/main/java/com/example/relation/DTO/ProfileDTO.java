package com.example.relation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {
    private Integer customer_id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
}
