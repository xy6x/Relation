package com.example.schoolmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "please enter name ")
    @Column(columnDefinition = "varchar(45) not null")
    private String name;
    @NotNull(message = "please enter your age")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email
    @Column(columnDefinition = "varchar(45) not null")
    private String email;
    @Positive
    @NotNull(message = "please enter your salary")
    @Column(columnDefinition = "int not null")
    private Float salary;
    @OneToOne(cascade = CascadeType.ALL,mappedBy ="teacher")
    @PrimaryKeyJoinColumn
     private Address address;

}
