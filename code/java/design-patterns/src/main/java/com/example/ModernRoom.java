package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

interface  DoorListener{
    void on();
    void off();
}

class Light implements DoorListener{
    public void on(){
        System.out.println("Light ON");
    }
    public void off(){
        System.out.println("Light OFF");
    }
}

class Fan implements DoorListener{
    public void on(){
        System.out.println("Fan ON");
    }
    public void off(){
        System.out.println("Fan OFF");
    }
}


class Door{

    private List<DoorListener> listeners = new ArrayList<>();

    public void addDoorListener(DoorListener listener){
        listeners.add(listener);
    }
    public void removeDoorListener(DoorListener listener){
        listeners.remove(listener);
    }

    public void open(){
        System.out.println("door opened");
        listeners.forEach(DoorListener::on);
    }
    public void close(){
        System.out.println("door closed");
        listeners.forEach(DoorListener::off);
    }
}

public class ModernRoom {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light=new Light();
        Fan fan=new Fan();

        door.addDoorListener(light);
        door.addDoorListener(fan);

        TimeUnit.SECONDS.sleep(2);
        door.open();
        TimeUnit.SECONDS.sleep(2);
        door.close();

        door.removeDoorListener(fan);

        TimeUnit.SECONDS.sleep(2);
        door.open();
        TimeUnit.SECONDS.sleep(2);
        door.close();



    }
}
