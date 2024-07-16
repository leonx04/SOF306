package com.example.day1;

import java.util.List;

public class Lambda {

    public static void main (String[] args) {
       demo1();
    }

    private static void demo1() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.forEach(i -> System.out.println(i));
    }
}
