package KI304.Plotskykh.Lab2;

import java.io.IOException;
import KI304.Plotskykh.Lab2.gun;

public class gunDriver {
    /*
    * gun driver :D
    * */
    public static void main() {
        try {
            gun gn = new gun(15, 5);
            gn.setName("Desert Eagle");
            var name  = gn.getName();
            System.out.println("name = " + name);
            var calibr = gn.getCaliber();
            System.out.println("calibr = " + calibr);
            var count = gn.getAmmoCount();
            System.out.println("count = " + count);
            gn.Shot();
            gn.Shot();
            count = gn.getAmmoCount();
            System.out.println("count = " + count);
            gn.reload();
            count = gn.getAmmoCount();
            System.out.println("count = " + count);
            gn.wearSilencer();
            gn.Shot();
            gn.Shot();
            count = gn.getAmmoCount();
            System.out.println("count = " + count);
            gn.reload();
            count = gn.getAmmoCount();
            System.out.println("count = " + count);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
