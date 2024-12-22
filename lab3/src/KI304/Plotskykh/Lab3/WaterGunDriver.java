package KI304.Plotskykh.Lab3;

import KI304.Plotskykh.Lab3.*;

import java.io.IOException;

public class WaterGunDriver {

    public WaterGunDriver() throws IOException {
        WaterGun wg = new WaterGun();
        wg.setName("WAtERGUN");
        wg.setAmmoCount(200);
        wg.setCaliber(50);
        wg.shoot();
        wg.shoot();
        wg.wearSilencer();
        wg.shoot();
        wg.shoot();
        wg.getAmmoCount();
        wg.getCaliber();
        wg.reload();
        wg.shoot();
        wg.takeOffSilencer();
    }
}
