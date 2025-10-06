import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class PadreProcesos {
    public static void main(String[] args) {
        File carpeta = new File("ficheros");
        File[] lista = carpeta.listFiles();
        if (lista == null) {
            System.out.println("No existe la carpeta o está vacía.");
            return;
        }

        int numeroFicheros = lista.length;
        System.out.println("Número de ficheros: " + numeroFicheros);

        // Lanzar un hijo por cada fichero
        for (int i = 0; i < numeroFicheros; i++) {
            String ruta = lista[i].getAbsolutePath();
            String id = String.valueOf(i + 1);

            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "java", "-cp", "bin;.", "Hijo", ruta, id
                );

                pb.inheritIO();
                Process p = pb.start();
                p.waitFor(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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

        // Guardar el total  en un fichero

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("totalVocales.res"))) {
            bw.write(String.valueOf(totalGeneral));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total general de vocales: " + totalGeneral);
    }
}
