package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Введите m и n:");
        Scanner in = new Scanner(System.in);
        double m_n = in.nextDouble();
        double n_n = in.nextDouble();
        double x;
        x = ((m_n - 1) * Math.sqrt(m_n) - (n_n - 1) * Math.sqrt(n_n)) / (Math.sqrt(Math.pow(m_n, 3) * n_n) + (n_n * m_n) + Math.pow(m_n, 2) - m_n);
        System.out.println("Ответ: " + x);
    }
}
