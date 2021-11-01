package com.company.Lab_7;

import java.util.Scanner;

public class Lab_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reader people = new Reader();
        System.out.print("Введите ФИО читателя ");
        Reader.fio = input.nextLine();
        System.out.print("Введите номер читательского билета ");
        people.rnum = input.nextInt();
        System.out.print("Введите факультет  ");
        people.fac = input.nextLine();
        input.nextLine();
        System.out.print("Введите дату рождения  ");
        people.date = input.nextLine();
        System.out.print("Введите номер телефона ");
        people.phone = input.nextLine();
        System.out.println("Чтобы взять книгу нужно ввести любой символ, а чтобы сдать просто нажмите enter");
        String quest = input.nextLine();


        if (quest.isEmpty()) {
            System.out.println("Введите количество книг, которые читатель хочет вернуть ");
            int quant = input.nextInt();
            String[] booknames = new String[quant];
            String temp = null;
            System.out.println("Введите книгу/книги (если нужно): ");
            for (int i = 0; i < quant; i++) {
                System.out.printf("Осталось ввести %s книг: ", quant - i);
                if (i == 0) {
                    input.nextLine();
                }
                temp = input.nextLine();
                booknames[i] = temp;
                if (temp.isEmpty()) {
                    break;
                }
            }


            assert temp != null;
            if (temp.isEmpty()) {
                Reader.returnBook(quant);
            } else {
                Reader.returnBook(quant, booknames);
            }

        } else {

            System.out.println("Введите количество книг, которые взял читатель ");
            int quant = input.nextInt();
            String[] booknames = new String[quant];
            String temp = null;
            System.out.println("Введите книгу/книги (если нужно): ");
            for (int i = 0; i < quant; i++) {
                System.out.printf("Осталось ввести %s книг: ", quant - i);
                if (i == 0) {
                    input.nextLine();
                }
                temp = input.nextLine();
                booknames[i] = temp;
                if (temp.isEmpty()) {
                    break;
                }
            }

            assert temp != null;
            if (temp.isEmpty()) {
                Reader.takeBook(quant);
            } else {
                Reader.takeBook(quant, booknames);
            }
        }
    }


    static class Reader{
        private static Object fio;
        int age;
        int rnum;
        String fac;
        String date;
        String phone;

        public static void takeBook(int num) {
            System.out.printf("%s взял(а) книг %d ", fio, num);
        }

        public static void takeBook(int num, String[] books) {
            if (books.length > 1) {
                System.out.printf("%s взял(а) книги: ", fio);
                for (int i = 0; i < books.length; i++) {
                    if (i == books.length - 1){
                        System.out.print(books[i] + "");
                    } else {
                        System.out.print(books[i] + ", ");
                    }
                }
            } else {
                System.out.printf("%s взял(а) книгу: %s", fio, books[0]);
            }

        }

        public static void returnBook(int num) {
            System.out.printf("%s вернул(а) книг %d ", fio, num);
        }

        public static void returnBook(int num, String[] books) {
            if (books.length > 1) {
                System.out.printf("%s вернул(а) книги: ", fio);
                for (int i = 0; i < books.length; i++) {
                    if (i == books.length - 1){
                        System.out.print(books[i] + "");
                    } else {
                        System.out.print(books[i] + ", ");
                    }
                }
            } else {
                System.out.printf("%s вернул(а) книгу: %s", fio, books[0]);
            }
        }
    }
}
