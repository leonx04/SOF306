package com.example.day1;

import com.example.day1.entity.SinhVien;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAPI {
    static List<SinhVien> list = Arrays.asList(
            new SinhVien("Nguyen Van A", "SV001", true, 8.5),
            new SinhVien("Nguyen Van B", "SV002", false, 7.5),
            new SinhVien("Nguyen Van C", "SV003", true, 9.5),
            new SinhVien("Nguyen Van D", "SV004", false, 6.5),
            new SinhVien("Nguyen Van E", "SV005", true, 5.5),
            new SinhVien("Nguyen Van F", "SV006", false, 4.5)
    );
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }

    private static void demo1() {
        Stream <Integer> stream1 = Stream.of(1, 2,4, 5, 6, 7, 3,  8, 9, 10);
        stream1.forEach(n1 -> System.out.println("n1 = " + n1));

        List<Integer> list = Arrays.asList(1, 2,6, 7, 8, 9, 3, 4, 5,  10);
        list.stream().forEach(n2 -> System.out.println("n2 = " + n2));
    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 2,6, 7, 8, 9, 3, 4, 5,  10);
        List<Double> result = list.stream() // Chuyển List thành Stream
                .filter(n3 -> n3 % 2 == 0) // Lọc số chẵn
                .map(n3 -> Math.sqrt(n3))   // Tính căn bậc 2
                .peek(d -> System.out.println(d)) // In ra màn hình
                .collect(Collectors.toList()); // Chuyển kết quả thành List
    }

    private static void demo3() {
        List<SinhVien> result = list.stream()
                .filter(sv -> sv.getDiem() >= 7)
                .peek(sv -> System.out.println(sv.getTenSV().toUpperCase()))
                .collect(Collectors.toList());

        result.forEach(sv -> {
            System.out.println("Ten SV: " + sv.getTenSV());
            System.out.println("Diem: " + sv.getDiem());
            System.out.println("===================================");
        });
    }

    private static void demo4(){
        double avg = list.stream()
                .mapToDouble(sv -> sv.getDiem())
                .average()
                .getAsDouble();
        System.out.println("Diem trung binh: " + avg);

        double sum = list.stream()
                .mapToDouble(sv -> sv.getDiem())
                .sum();
        System.out.println("Tong diem: " + sum);

        double max = list.stream()
                .mapToDouble(sv -> sv.getDiem())
                .max()
                .getAsDouble();
        System.out.println("Diem cao nhat: " + max);


        boolean count = list.stream()
                .allMatch(sv -> sv.getDiem() >= 5);
        System.out.println("Sinh vien co diem >= 5: " + count);

        SinhVien minsv = list.stream()
                .reduce(list.get(0), (min, sv ) -> sv.getDiem() < min.getDiem() ? sv : min);
        System.out.println("Sinh vien co diem thap nhat: " + minsv.getTenSV());
    }
}
