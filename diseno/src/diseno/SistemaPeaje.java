package diseno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPeaje {
    public static void main(String[] args) {
        EstacionPeaje estacion = cargarEstacionDesdeArchivo();
        if (estacion == null) {
            estacion = new EstacionPeaje("Peaje A", "Departamento X");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar Peaje");
            System.out.println("2. Consultar Registros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de vehículo (carro/moto/camion): ");
                    String tipo = scanner.nextLine().toLowerCase();

                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.nextLine();

                    int cilindraje = 0;
                    int ejes = 0;

                    if ("moto".equalsIgnoreCase(tipo)) {
                        System.out.print("Ingrese el cilindraje de la moto: ");
                        cilindraje = scanner.nextInt();
                    } else if ("camion".equalsIgnoreCase(tipo)) {
                        System.out.print("Ingrese el número de ejes del camión: ");
                        ejes = scanner.nextInt();
                    }

                    Vehiculo vehiculo = new Vehiculo(placa, tipo, cilindraje, ejes);
                    estacion.registrarPeaje(vehiculo);
                    break;

                case 2:
                    estacion.imprimirRegistros();
                    break;

                case 3:
                    guardarEstacionEnArchivo(estacion);
                    System.out.println("Fin");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static EstacionPeaje cargarEstacionDesdeArchivo() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("registros_peaje.dat"))) {
            return (EstacionPeaje) inputStream.readObject();
        } catch (FileNotFoundException e) {
            return null; 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void guardarEstacionEnArchivo(EstacionPeaje estacion) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("registros_peaje.dat"))) {
            outputStream.writeObject(estacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}