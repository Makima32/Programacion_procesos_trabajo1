import java.io.*;
import java.util.*;

public class Hijo {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Faltan argumentos: <ruta fichero> <id>");
            return;
        }

        String rutaFichero = args[0];
        String id = args[1];

        List<String> palabras = new ArrayList<>();

        // Lee el fichero y guarda palabras
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    palabras.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Guarda palabras en minúsculas en minusculasX.res
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("minusculas" + id + ".res"))) {
            for (String palabra : palabras) {
                bw.write(palabra.toLowerCase() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Contar vocales
        int totalVocales = 0;
        for (String palabra : palabras) {
            totalVocales += contarVocales(palabra.toLowerCase());
        }

        // Guardar el total de vocales en vocalesX.res
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vocales" + id + ".res"))) {
            bw.write(String.valueOf(totalVocales));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hijo " + id + " procesó " + palabras.size() + " palabras.");
        System.out.println("Total de vocales: " + totalVocales);
    }

    private static int contarVocales(String palabra) {
        int contador = 0;
        String vocales = "aeiouáéíóúü";
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;

    
    }

    // private static int hola(){


    // return 0;
    // }
}
