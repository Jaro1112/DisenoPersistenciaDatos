package diseno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehiculo implements Serializable {
    private String placa;
    private String tipo;
    private int cilindraje;
    private int ejes;

    public Vehiculo(String placa, String tipo, int cilindraje, int ejes) {
        this.placa = placa;
        this.tipo = tipo;
        this.cilindraje = cilindraje;
        this.ejes = ejes;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public int getEjes() {
        return ejes;
    }
}
