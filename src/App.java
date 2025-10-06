public class App {
    public static void main(String[] args) {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "bin;.", "PadreProcesos"
            );

            pb.inheritIO(); // Ve la salida de hijos en consola

            Process p = pb.start();

            p.waitFor(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
