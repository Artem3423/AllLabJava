package com.company.Lab_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = in.nextLine();// вводим строчку
        System.out.println(str);
        String [] words = str.split(" ");// заносим в массив слова
        String min = words[0];// допускаем что первый элемент самый маленький
        for (String word : words) {// проходим по массиву
            if (word.length() < min.length()) {
                min = word;
            }
        }
        System.out.println(min);
    }
}