package com.company.Lab_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for(int i = 1; i < n; ++i) {
            int x = 2 * i - 1;
            nums[i - 1] = x;
            System.out.println("Ответ: " + nums[i - 1]);
        }

    }
}
