package com.example.day1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien2 {
    private String name;
    private String gender;
    private String marks;
    private Contact contact;
    private List<String> subjects;
}
