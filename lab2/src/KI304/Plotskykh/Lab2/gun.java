package KI304.Plotskykh.Lab2;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class gun {
    private BufferedWriter logWriter;
    private String name;
    private static int ammoCount;
    private int caliber;
    private int copy;
    private boolean silencer;
    /*
    * constructor
    * */
    public gun() throws IOException {
        this.name = "";
        this.ammoCount = 0;
        this.caliber = 0;
        this.copy = 0;
        this.silencer = false;
        this.logWriter = new BufferedWriter(new FileWriter("gun_log.txt", true));
    }
    /**
     * constructor
     * @param name name of gun
     */
    public gun(String name) throws IOException {
        this.name = name;
        this.silencer = false;
        this.logWriter = new BufferedWriter(new FileWriter("gun_log.txt", true));
    }
    /**
     * constructor
     * @param ammoCount is a qantity of bullets in the magazine
     * @param caliber  is a caliber of gun
     */
    public gun(int ammoCount, int caliber) throws IOException {
        this.ammoCount = ammoCount;
        this.caliber = caliber;
        this.copy = ammoCount;
        this.silencer = false;
        this.logWriter = new BufferedWriter(new FileWriter("gun_log.txt", true));
    }

    /**
     * logging code in the txt file
     */
    private void log(String message) throws IOException {
        logWriter.write(message);
        logWriter.newLine();
        logWriter.flush();
    }

    /*
    * setter
    * @param name set in the name of gun
    * */
    public void setName(String name) throws IOException {
        log("added name - " + name);
        this.name = name;
    }


    public void setAmmoCount(int ammoCount) throws IOException {
        log("added ammoCount - " + ammoCount);
        this.ammoCount = ammoCount;
        this.copy = ammoCount;
    }
    public void setCaliber(int caliber) throws IOException {
        this.caliber = caliber;
    }
    public String getName() throws IOException {
        log("gun::getName() - " + this.name);
        return this.name;
    }
    public int getAmmoCount() throws IOException {
        log("gun::getAmmoCount() - " + this.ammoCount);
        return this.ammoCount;
    }
    public int getCaliber(){
        return this.caliber;
    }

    /**
     * Shot() is a function that allows gun to shot, also into the implementation we have
     * check if the silencer is taken off or not
     * added decrementation of bullets
     * if the magazine haven't any bullets, the function will log that magazine is empty
     */
    public void Shot() throws IOException {
        log("gun::Shot()");
        if(this.ammoCount > 0) {
            if(!this.silencer){
                log(this.name + " shot");
                System.out.println(this.name + " shot");
                this.ammoCount--;
            }
            else {
                log(this.name + " quiet shot");
                System.out.println(this.name + " quiet shot");
                this.ammoCount--;
            }
        }
        else{
            log(this.name + " not shot, please reload magazine");
            System.out.println(this.name + " Not Shot, please reload magazine");
        }
    }

    public void reload(){

        this.ammoCount = copy;
    }

    public void wearSilencer() throws IOException {
        log("gun::wearSilencer()");
        this.silencer = true;
    }
    public void takeOffSilencer() throws IOException {
        log("gun::takeOffSilencer()");
        this.silencer = false;
    }
}
