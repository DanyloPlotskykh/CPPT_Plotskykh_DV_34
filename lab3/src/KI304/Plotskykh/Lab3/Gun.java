package KI304.Plotskykh.Lab3;

import java.io.IOException;

public abstract interface Gun {
    // Методи, які повинні бути реалізовані класами
    void setName(String name) throws IOException;
    void setAmmoCount(int ammoCount) throws IOException;
    void setCaliber(int caliber) throws IOException;

    String getName() throws IOException;
    int getAmmoCount() throws IOException;
    int getCaliber()  throws IOException ;

    void shoot() throws IOException;  // Метод для пострілу
    void reload()  throws IOException ;                    // Метод для перезарядки

    void wearSilencer() throws IOException;  // Надіти глушник
    void takeOffSilencer() throws IOException;  // Зняти глушник
}

