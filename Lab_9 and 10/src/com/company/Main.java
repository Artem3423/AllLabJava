package com.company;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip;
        System.out.println("Введите IPv4-адрес: ");
        String ipv4 = in.nextLine();
        boolean x = ipv4.matches(
                "(([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.)" +
                        "((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){2}" +
                        "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])");
        if(x) {
            ip = "IP-адрес верный.";
            System.out.println("IP-адрес верный.");
        }
        else{
            ip = "IP-адрес неверный.";
            System.out.println("IP-адрес неверный.");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("IP-адрес.txt"))){
            bw.write(ipv4 + " ");
            bw.write(ip);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        String g = in.nextLine();
        if (g.equals("log")){
            try(BufferedReader br = new BufferedReader(new FileReader("IP-адрес.txt"))){
                String I;
                if ((I = br.readLine())!= null){
                    System.out.println(I);
                }}
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
