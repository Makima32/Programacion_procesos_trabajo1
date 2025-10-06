import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ficheros {

    String ruta;
    String id;
    ArrayList<String> lista;


    public void BorrarFicheros() {
        
    File carpeta = new File("."); // o "." si quieres la carpeta actual
    File[] lista = carpeta.listFiles();

    if (lista != null) {
        for (File fichero : lista) {
            String nombre = fichero.getName().toLowerCase();
            if (nombre.endsWith(".res") || nombre.endsWith(".txt")) {
                boolean eliminado = fichero.delete();
                if (eliminado) {
                    System.out.println(" Borrado: " + fichero.getName());
                } else {
                    System.out.println(" No se pudo borrar: " + fichero.getName());
                }
            }
        }
    }
    }

    public Ficheros(String ruta, String id, ArrayList<String> lista) {
        this.ruta = ruta;
        this.id = id;
        this.lista = lista;

    }

    // Lee el fichero y guarda palabras
    public void LeerYGuardar() {

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lista.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    // Guarda palabras en minúsculas en minusculasX.res

    public void GuardarEnFicheroMinusculas() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("minusculas" + id + ".res"))) {
            for (String palabra : lista) {
                bw.write(palabra.toLowerCase() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Guardar el total de vocales en vocalesX.res

    public void guardarTotalVocales(int totalVocales) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vocales" + id + ".res"))) {
            bw.write(String.valueOf(totalVocales));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
