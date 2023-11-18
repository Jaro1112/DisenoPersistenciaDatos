package diseno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EstacionPeaje implements Serializable {
    private String nombre;
    private String departamento;
    private double totalRecaudado;
    private List<Vehiculo> registros;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalRecaudado = 0.0;
        this.registros = new ArrayList<>();
    }

    public void registrarPeaje(Vehiculo vehiculo) {
        double valorPeaje = calcularValorPeaje(vehiculo);
        totalRecaudado += valorPeaje;
        registros.add(vehiculo);
        System.out.println("Registrado: " + vehiculo.getTipo() + " - Placa: " + vehiculo.getPlaca() + " - Valor: $" + valorPeaje);
    }

    public void imprimirRegistros() {
        System.out.println("Registros de Peaje:");
        for (Vehiculo vehiculo : registros) {
            System.out.println(vehiculo.getTipo() + " - Placa: " + vehiculo.getPlaca());
        }
        System.out.println("Total Recaudado: $" + totalRecaudado);
    }

    private double calcularValorPeaje(Vehiculo vehiculo) {
        if ("carro".equalsIgnoreCase(vehiculo.getTipo())) {
            return 10000;
        } else if ("moto".equalsIgnoreCase(vehiculo.getTipo())) {
            return (vehiculo.getCilindraje() > 200) ? 7000 : 5000;
        } else if ("camion".equalsIgnoreCase(vehiculo.getTipo())) {
            return 5000 * vehiculo.getEjes();
        } else {
            return 0; // cuando el vehiculo no es valido
        }
    }
}
