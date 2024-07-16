package com.example.day1;

public class Demo4 {

    @FunctionalInterface
    interface Demo4Interface {
        void m1(int x);

        default void m2() {

        }

        public static void m3() {

        }
    }

    public static void main(String[] args) {
        demo4();
        demo5();
    }

    //Traditional
    private static void demo4() {
        Demo4Interface a = new Demo4Interface() {
            @Override
            public void m1(int x) {
                System.out.println("Hello " + x);
            }
        };
        a.m1(10);
    }
    // Lambda
    private static void demo5() {
        Demo4Interface a = (x) -> {
            System.out.println("Hello " + x);
        };
        a.m1(10);
    }
}
