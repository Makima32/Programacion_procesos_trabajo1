import java.util.ArrayList;

/**
 * Clase encargada de procesar un único fichero de texto.
 * 
 * Cada proceso hijo:
 * <ul>
 * <li>Lee el contenido del fichero indicado</li>
 * <li>Guarda todas las palabras en una lista</li>
 * <li>Genera un fichero con las palabras en minúsculas</li>
 * <li>Cuenta las vocales y guarda el resultado</li>
 * </ul>
 */

public class Hijo {
    /**
     * Clase encargada de procesar un único fichero de texto.
     * 
     * Cada proceso hijo:
     * <ul>
     * <li>Lee el contenido del fichero indicado</li>
     * <li>Guarda todas las palabras en una lista</li>
     * <li>Genera un fichero con las palabras en minúsculas</li>
     * <li>Cuenta las vocales y guarda el resultado</li>
     * </ul>
     */

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Faltan argumentos: <ruta fichero> <id>");
            return;
        }

        String rutaFichero = args[0];
        String id = args[1];
        ArrayList<String> palabras = new ArrayList<>();

        Ficheros f = new Ficheros(rutaFichero, id, palabras);

        Vocales v = new Vocales();

        f.LeerYGuardar();

        f.GuardarEnFicheroMinusculas();

        // Guardamos en una variable totalVocales, para no llamar al metodo cada vez que
        // necesite el dato

        int totalVocales = v.contarVocalesTotales(palabras);

        f.guardarTotalVocales(totalVocales);

        System.out.println("Hijo " + id + " procesó " + palabras.size() + " palabras y " + totalVocales + " vocales ");
    }

}
