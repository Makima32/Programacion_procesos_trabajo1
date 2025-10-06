import java.util.ArrayList;

public class Hijo {
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

        // Guardamos en una variable totalVocales, para no llamar al metodo cada vez que necesite el dato
        int totalVocales = v.contarVocalesTotales(palabras);

        // Guardar el total de vocales en vocalesX.res

       f.guardarTotalVocales(totalVocales);

        System.out.println("Hijo " + id + " procesó " + palabras.size() + " palabras.");
        System.out.println("Total de vocales: " + totalVocales);
    }

   
}
