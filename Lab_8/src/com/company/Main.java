package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = in.nextLine();
        String [] mas = str.split(" ");
        String min = mas[0];
        for (String elem : mas) {
            if (elem.length() < min.length()) {
                min = elem;
            }
        }
        System.out.println(min);
    }
}


