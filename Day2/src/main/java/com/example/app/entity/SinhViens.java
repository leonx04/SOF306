package com.example.app.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SinhViens {
    private String name;
    private Boolean  gender;
    private Double mark = 0.0;
    private String email;
}
