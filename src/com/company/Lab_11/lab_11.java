package com.company.Lab_11;

import java.io.*;
public class lab_11 {
        public static void main(String[] args) throws FileNotFoundException {
            try(BufferedReader br = new BufferedReader(new FileReader("lab_11.txt"));
                FileWriter fw = new FileWriter("lab_11e.txt")){
                String rstr;
                String temp = null;
                boolean tmp = false;
                boolean tmp2 = false;
                boolean check = false;
                int ind;
                while  ((rstr = br.readLine()) != null) { //2egwe
                    tmp = false;
                    tmp2 = false;

                    for (int i = 0; i < rstr.length(); i++) { // проверка на пустую строку
                        if (!Character.toString(rstr.charAt(i)).equals(" ")) {
                            tmp = true;
                        } else {
                            tmp2 = true;

                        }
                    }

                    if (!tmp & tmp2) {
                        continue;
                    }
                    if (!tmp & !tmp2) {
                        continue;
                    }

                    ind = rstr.indexOf("//");  // удаление однострочных комментариев
                    if (ind > 0) {
                        temp = rstr.substring(0, ind);
                        fw.write(temp + "\n");
                        System.out.print(temp + "\n");
                        continue;
                    }

                    if (rstr.contains("/*")){
                        ind = rstr.indexOf("/*");
                        temp = rstr.substring(0, ind);
                        check = true;
                        fw.write(temp + "\n");
                        System.out.print(temp + "\n");
                        continue;
                    }

                    if (rstr.contains("*/")){
                        ind = rstr.indexOf("*/");
                        temp = rstr.substring(ind + 2);
                        check = false;
                        fw.write(temp + "\n");
                        System.out.print(temp + "\n");
                        continue;
                    }
                    if (check) {
                        continue;
                    }

                    System.out.print(rstr + "\n");

                    if (temp != null) {
                        fw.write(rstr + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }