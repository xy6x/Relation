package com.example.relation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Profile{
    @Id
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String gender;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
