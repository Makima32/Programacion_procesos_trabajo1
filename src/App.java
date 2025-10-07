/**
 * Programa principal, llama a clase PadreProcesos y lo inicia como un proceso.
 */

public class App {

    /**
     * Inicio del programa llamada a PadreProcesos.
     * * Esta clase crea un proceso que ejecuta la clase {@link PadreProcesos},
     * 
     * @author Omar
     * @version 1.0
     */
    public static void main(String[] args) {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", "bin;.", "PadreProcesos");

            pb.inheritIO(); // Ve la salida de hijos en consola

            Process p = pb.start();

            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
