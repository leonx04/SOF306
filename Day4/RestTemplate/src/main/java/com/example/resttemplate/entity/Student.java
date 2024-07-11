package com.example.resttemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
   public String email;
    public String country;
    public String fullname;
    public Double marks;
    public Boolean gender;
}
