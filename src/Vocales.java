import java.util.ArrayList;

public class Vocales {
    

    int numerovocales = 0;

    // Contar vocales
  public int contarVocalesTotales(ArrayList<String> lista) {
    int totalVocales = 0;
    String vocales = "aeiouáéíóúü";

    for (String palabra : lista) {
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.toLowerCase().charAt(i);
            if (vocales.indexOf(c) != -1) {
                totalVocales++;
            }
        }
    }

    return totalVocales;
}

 

}

