package KI304.Plotskykh.Lab3;

import KI304.Plotskykh.Lab3.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WaterGun extends IOException{
    /**
     * capacity in milliliters
     */
    private int capacity;
    private int speed; //ml per seconds
    private String name;
    private boolean silencer;
    private int tmp;
    private BufferedWriter logWriter;
    //-----------------------------

    public WaterGun() throws IOException{
        this.name = "";
        this.capacity = 0;
        this.speed = 0;
        this.silencer = false;
        this.tmp = 0;
        this.logWriter = new BufferedWriter(new FileWriter("gun_log.txt", true));
        log("WaterGun::WaterGun()");
    }

    private void log(String message) throws IOException {
        logWriter.write(message);
        logWriter.newLine();
        logWriter.flush();
    }

    public void setName(String name) throws IOException{
        log("WaterGun::setName()");
        this.name = name;
    }
    public void setAmmoCount(int capacity) throws IOException{
        log("WaterGun::setAmmoCount()");
        log("capacity: " + capacity);
        this.capacity = capacity;
        this.tmp = capacity;
    }
    public void setCaliber(int ml_per_second) throws IOException{
        log("WaterGun::setCaliber()");
        log("ml_per_second: " + ml_per_second);
        this.speed = ml_per_second;
    }
    public void wearSilencer() throws IOException {
        log("WaterGun::wearSilencer()");
        log("silencer was taken");
        this.silencer = true;
    }
    public String getName() throws IOException{
        log("WaterGun::getName()");
        log("name: " + name);
        return name;
    }
    public int getAmmoCount() throws IOException{
        log("WaterGun::getAmmoCount()");
        log("ammoCount: " + tmp);
        return capacity;
    }
    public int getCaliber() throws IOException {
        log("WaterGun::getCaliber()");
        log("caliber: "  + speed);
        return speed;
    }
    public void takeOffSilencer() throws IOException {
        log("WaterGun::takeOffSilencer()");
        log("silencer was taken off");
        this.silencer = false;
    }
    public void shoot() throws IOException{
        log("WaterGun::shot()");
        if(capacity <= 0){
            System.out.println("Capacity equal 0 please fill the tank");
            log("Capacity equal 0 please fill the tank");
        }
        if(!silencer){
            System.out.println(this.name + "water shot!");
            log(this.name + "water shot!");
            capacity -= speed;
        }
        else{
            System.out.println(this.name + " long water shot");
            log(this.name + " long water shot");
            capacity -= speed;
        }
    }
    public void reload() throws IOException{
        log("WaterGun::reload()");
        this.capacity = this.tmp;
    }
}
