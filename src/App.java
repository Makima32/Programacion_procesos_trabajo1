public class App {
    public static void main(String[] args) {
        try {
            // Lanza el proceso padre
            ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "bin;.", "PadreProcesos"
            );

            pb.inheritIO(); // Ver su salida en consola

            Process p = pb.start();

            p.waitFor(); // Espera a que PadreProcesos termine

            System.out.println("Finalizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
