package service;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    public static void guardarDatos(ArrayList<String> datos) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("datos.txt"));

            for (String dato : datos) {

                bw.write(dato);
                bw.newLine();
            }

            bw.close();

            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {

            System.out.println("Error al guardar datos");
        }
    }

    public static ArrayList<String> leerDatos() {

        ArrayList<String> datos = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("datos.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                datos.add(linea);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error al leer datos");
        }

        return datos;
    }
}