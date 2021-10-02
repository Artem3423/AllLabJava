package com.company;

interface MaxEnergy {
    void connect();
    void BasicCharge();
    void StopBasicCharge();
}

interface BaseEnergy {
    void connect();
    void SlowlyCharge();
    void StopSlowlyCharge();
}

class Fast implements MaxEnergy {
    @Override
    public void connect(){
        System.out.println("Зарядка началась");
    }

    @Override
    public void BasicCharge(){
        System.out.println("Зарядка напряжением 380 вольт");
    }

    @Override
    public void StopBasicCharge(){
        System.out.println("Зарядка остановелена");
    }
}

class Slow implements BaseEnergy {

    @Override
    public void connect(){
        System.out.println("Особая зарядка началась");
    }

    @Override
    public void SlowlyCharge(){
        System.out.println("Зарядка напряжением 220 вольт");
    }

    @Override
    public void StopSlowlyCharge(){
        System.out.println("Зарядка остановлена");
    }
}

class PortAdapter implements MaxEnergy {
    BaseEnergy NormalEnergy;

    public PortAdapter(BaseEnergy EnergyNormal){
        this.NormalEnergy = EnergyNormal;
    }

    @Override
    public void connect(){
        NormalEnergy.connect();
    }

    @Override
    public void BasicCharge(){
        NormalEnergy.SlowlyCharge();
    }

    @Override
    public void StopBasicCharge(){
        NormalEnergy.StopSlowlyCharge();
    }
}

class Centralprocessor {
    public MaxEnergy phone;
    public Centralprocessor(MaxEnergy phone){
        this.phone = phone;
    }
    public void charge(){
        phone.connect();
        phone.BasicCharge();
        phone.StopBasicCharge();
    }
}

public class Lab_16 {
    public static void main(String[] args){
        MaxEnergy charge = new Fast();
        Centralprocessor cp = new Centralprocessor(charge);
        cp.charge();
        PortAdapter now = new PortAdapter(new Slow());
        Centralprocessor cp2 = new Centralprocessor(now);
        cp2.charge();
    }
}