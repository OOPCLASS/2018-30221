package com.company;

public class MainController {
    private final int roomCap = 10;
    Room[] rooms = new Room[roomCap];
    private int roomIndex = 0;
    private String status;

    public MainController(){

    }
    public void turnOffAllSmartDevices(){
        for(int i = 0; i < roomIndex; i++){
            SmartDevice[] roomDevice = rooms[i].getSmartDevices();
            for(int j = 0; j < rooms[i].getSize(); j++){
                roomDevice[i].turnOff();
            }
        }
    }
    public void turnOnAllSmartDevices(){
        for(int i = 0; i < roomIndex; i++){
            SmartDevice[] roomDevice = rooms[i].getSmartDevices();
            for(int j = 0; j < rooms[i].getSize(); j++){
                roomDevice[i].turnOn();
            }
        }
    }
    public void addRoom(Room room){
        if(roomIndex < roomCap){
            rooms[roomIndex] = room;
            roomIndex++;
            System.out.println("Room was added");
        }else System.out.println("Room was not added");


    }
    public SmartDevice[] getAllSmartDevices(){
        SmartDevice[] smartAux = new SmartDevice[5];
        SmartDevice[] smart = new SmartDevice[50];
        int index = 0;
        for(int i = 0; i < roomIndex; i++) {
            smartAux = rooms[i].getSmartDevices();
            for(int j = 0; j < rooms[i].getSize();j++){
                smart[index] = smartAux[j];
                index++;
            }
        }
        return smart;
    }
    public String getStatus(){
        String status = new String();
        for(int i = 0; i < roomIndex; i++) {
            status = status + "\n" + rooms[i].getStatus();
        }
        return status;
    }
}
