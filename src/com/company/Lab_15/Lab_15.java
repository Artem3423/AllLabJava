package com.company.Lab_15;

import java.util.ArrayList;
import java.util.List;

public class Lab_15 {

    public static void main(String[] args) {

        Server pub1 = new Server();
        VKClient vkcl1 = new VKClient(pub1);
        pub1.changeData("Мемы", 1248617);

        Server pub2 = new Server();
        VKClient vkcl2 = new VKClient(pub2);
        pub2.changeData("Гифки", 54982);

        Server pub3 = new Server();
        VKClient vkcl3 = new VKClient(pub3);
        pub3.changeData("Фотки", 825417);
    }
}

interface Informer {
    void addSubrcriber(User obs);
}

class Server implements Informer { //класс, рассылатель событий
    private final List subscribers;
    private String pubname;
    private int subquant;


    public Server(){
        subscribers = new ArrayList();
    }


    public void addSubrcriber(User obs) { //регаем подписчиков Регистрация происходит в момент создания объекта VKClient
        subscribers.add(obs);
    }

    public void notifySubcribers() { //Вызывает Info для обновы
        for (Object subscriber : subscribers) {
            User obs = (User) subscriber;
            obs.info(pubname, subquant);
        }
    }

    public void changeData(String pubname, int subquant){
        this.subquant = subquant;
        this.pubname = pubname;
        notifySubcribers();
    }
}

interface User { //ри этом слушатель заносится в список
    void info(String pubname, int subquant);
}

class VKClient implements User { //класс, слушатель событий
    private String pubname;
    private int subquant;


    public VKClient(Informer informer){
        informer.addSubrcriber(this);
    }

    public void info(String pubname, int subquant) {
        this.subquant = subquant;
        this.pubname = pubname;
        show();
    }

    public void show(){
        System.out.println("Название паблика: " + pubname + ", подписчиков: " + subquant);
    }
}