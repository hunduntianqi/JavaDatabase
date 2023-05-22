package com.database;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        for (int i = 0; i < 10; i++) {
            System.out.println(10 - i);
            Thread.sleep(1000);
        }
    }
}