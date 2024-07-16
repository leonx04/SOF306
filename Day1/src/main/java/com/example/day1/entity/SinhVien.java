package com.example.day1.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    public String tenSV;
    public String maSV;

    public  boolean gioiTinh = false;
    double diem = 0.0;
}
