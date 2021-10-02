package com.company;

import java.lang.*;
class Hex {
    private static final Hex cb = new Hex();
    private int item;

    private Hex(){
        this.item = 3;
    }

    public static Hex loot(){
        return cb;
    }

    public int getItems(){
        return item;
    }

    public void Items(int item){
        this.item = item;
    }
}

class Lab_14{
    public static void main(String[] args) {
        Hex Player = Hex.loot();
        System.out.println("У игрока в рюкзаке " + Player.getItems() + " вещи");
        Player.Items(5);
        Hex Player1 = Hex.loot();
        System.out.println("У игрока в рюкзаке " + Player1.getItems() + " вещей");
    }
}