package com.company;

public class Room {
    private String name;
    private final int maxSmartDevices = 5;
    private int deviceIndex = 0;
    SmartDevice[] smartDevices = new SmartDevice[maxSmartDevices];


    public Room(String name) {
        this.name = name;
    }

    public boolean addSmartDevice(SmartDevice smartDevice){
        if (deviceIndex < maxSmartDevices) {
            smartDevices[deviceIndex] = smartDevice;
            System.out.println("New smart device was successfully added");
            deviceIndex++ ;
            return true;
        }
        else{
            System.out.println("The smart device was not added");
            return false;
        }
    }
    public String getName() {
        return name;
    }

    public SmartDevice[] getSmartDevices() {
        return smartDevices;
    }
    public int getSize(){
        return deviceIndex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus(){
        String room = getName();
        for(int i = 0; i < deviceIndex ; i++){
            room = room +"\n" + " Device number: " + i + " " + smartDevices[i].getStatus();
        }
        return room;
    }
}
