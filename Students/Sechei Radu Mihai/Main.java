package com.company;

public class Main {

    public static void main(String[] args) {
    SmartLightBulb philips = new SmartLightBulb(5,"Becul Destept",true,"blue",10);
    SmartThermometer dona = new SmartThermometer(6,"Termometru Destept",false,36.7);
    SmartLightBulb samsung = new SmartLightBulb(7,"Becul Super Destept",false,"red",25);
    SmartThermometer catena = new SmartThermometer(8,"Termometrul Super Destept",true,38.5);
     Room livingRoom = new Room("livingroom");
     livingRoom.addSmartDevice(philips);
     livingRoom.addSmartDevice(dona);
     Room kitchen = new Room("Kitchen");
     kitchen.addSmartDevice(samsung);
     kitchen.addSmartDevice(catena);
     MainController telecomanda = new MainController();
     telecomanda.addRoom(kitchen);
     telecomanda.addRoom(livingRoom);
     System.out.println(telecomanda.getStatus());


    }
}
