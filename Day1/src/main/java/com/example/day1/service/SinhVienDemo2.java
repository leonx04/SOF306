package com.example.day1.service;

import com.example.day1.entity.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinhVienDemo2 {
    public static List<SinhVien> list;

    static {
        list = new ArrayList<>();
        list.add(new SinhVien("Nguyen Van A", "SV001", true, 8.5));
        list.add(new SinhVien("Nguyen Van B", "SV002", false, 7.5));
        list.add(new SinhVien("Nguyen Van C", "SV003", true, 9.5));
        list.add(new SinhVien("Nguyen Van D", "SV004", false, 6.5));
        list.add(new SinhVien("Nguyen Van E", "SV005", true, 5.5));
        list.add(new SinhVien("Nguyen Van F", "SV006", false, 4.5));
    }

    public static void demo2(){
        // Sắp xếp danh sách theo điểm giảm dần
        Collections.sort(list, (sv1, sv2) -> Double.compare(sv2.getDiem(), sv1.getDiem()));

        list.forEach(sv -> {
            System.out.println("Ten SV: " + sv.getTenSV());
            System.out.println("Ma SV: " + sv.getMaSV());
            System.out.println("Gioi tinh: " + (sv.isGioiTinh() ? "Nam" : "Nu"));
            System.out.println("Diem: " + sv.getDiem());
            System.out.println("===================================");
        });
    }

    public static void main(String[] args) {
        demo2();
    }
}
