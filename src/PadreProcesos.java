import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

/**
 * Clase encargada de gestionar los procesos hijos que procesan los ficheros de
 * texto.
 * 
 * Se encarga de:
 * <ul>
 * <li>Borrar ficheros .txt y .res anteriores</li>
 * <li>Identificar los ficheros válidos (datosX.txt)</li>
 * <li>Crear un proceso hijo por cada fichero</li>
 * <li>Sumar los resultados de cada hijo (número de vocales)</li>
 * <li>Guardar el total general de vocales en un fichero de salida</li>
 * </ul>
 */

public class PadreProcesos {

    public static void main(String[] args) {

        File carpeta = new File("ficheros");
        File[] lista = carpeta.listFiles();
        ArrayList<File> ficherosValidos = new ArrayList<>();

        // No declaro ninguna de sus variables porque solo usare la funcion de borrar y
        // no necesito de ningun param
        Ficheros f = new Ficheros(null, null, null);

        f.BorrarFicheros();

        if (lista == null) {
            System.out.println("No existe la carpeta o está vacía.");
            return;
        }

        for (File fichero : lista) {
            String nombre = fichero.getName();
            if (nombre.matches("datos\\d+\\.txt")) {
                ficherosValidos.add(fichero);
            } else {
                System.out.println("Fichero con nombre incorrecto: " + nombre);
            }
        }

        // Si no hay ficheros válidos, salimos

        if (ficherosValidos.isEmpty()) {
            System.out.println("No se encontraron ficheros válidos.");
            return;
        }

        int numeroFicheros = ficherosValidos.size();

        // Lanzar un hijo por cada fichero
        for (int i = 0; i < numeroFicheros; i++) {
            String ruta = ficherosValidos.get(i).getAbsolutePath();
            String id = String.valueOf(i + 1);

            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "java", "-cp", "bin;.", "Hijo", ruta, id);

                pb.inheritIO();
                Process p = pb.start();
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Contar numero de vocales

        int totalGeneral = 0;

        for (int i = 1; i <= numeroFicheros; i++) {
            File ficheroVocales = new File("vocales" + i + ".res");
            if (ficheroVocales.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(ficheroVocales))) {
                    String contenido = br.readLine();
                    if (contenido != null && !contenido.trim().isEmpty()) {
                        totalGeneral += Integer.parseInt(contenido.trim());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No se encontró el fichero: " + ficheroVocales.getName());
            }
        }

        // Guarda el total en un fichero

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("totalVocales.res"))) {
            bw.write(String.valueOf(totalGeneral));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total de vocales: " + totalGeneral);
    }

}
