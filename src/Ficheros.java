import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Ficheros proporciona métodos para gestionar archivos de texto,
 * incluyendo la lectura, almacenamiento de palabras, borrado de archivos
 * específicos y escritura de resultados en archivos de salida.
 * 
 * @author (Omar Torres)
 * @version 1.0
 */
public class Ficheros {

    /** Ruta del fichero con el que se trabaja. */
    String ruta;

    /** Identificador del fichero, usado para crear los ficheros de salida. */
    String id;

    /** Lista de líneas o palabras leídas desde el fichero original. */
    ArrayList<String> lista;

    /**
     * Constructor de la clase {@code Ficheros}.
     *
     * @param ruta  Ruta del fichero que se va a procesar.
     * @param id    Identificador del fichero (por ejemplo, su número).
     * @param lista Lista donde se almacenarán las líneas leídas.
     */

    public Ficheros(String ruta, String id, ArrayList<String> lista) {
        this.ruta = ruta;
        this.id = id;
        this.lista = lista;

    }

    /**
     * Elimina todos los ficheros con extensión <code>.res</code> o
     * <code>.txt</code>
     * del directorio actual.
     */

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

    /**
     * Lee el contenido del fichero indicado en {@code ruta} y
     * guarda cada línea no vacía en la lista {@code lista}.
     * 
     * <p>
     * Si ocurre un error durante la lectura, se muestra un mensaje en consola.
     * </p>
     * 
     * @throws IOException Si hay un problema al leer el archivo.
     */

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

    /**
     * Guarda las palabras almacenadas en {@code lista} en un nuevo
     * archivo con el nombre <code>minusculasX.res</code>, donde X es el ID del
     * fichero.
     * 
     * <p>
     * Todas las palabras se convierten a minúsculas antes de escribirse.
     * </p>
     * 
     * @throws IOException Si ocurre un error al escribir el fichero.
     */

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

    /**
     * Guarda el número total de vocales encontradas en un fichero
     * con el nombre <code>vocalesX.res</code>, donde X corresponde al ID.
     * 
     * @param totalVocales Número total de vocales a escribir en el fichero.
     * @throws IOException Si ocurre un error al escribir el fichero.
     */
    public void guardarTotalVocales(int totalVocales) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vocales" + id + ".res"))) {
            bw.write(String.valueOf(totalVocales));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
