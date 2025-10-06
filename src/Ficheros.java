import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ficheros {
    
    public void LeerYGuardar(String rutaFichero, ArrayList<String> palabras) {
        
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
    }


}
