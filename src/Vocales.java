import java.util.ArrayList;

/**
 * Clase que contiene métodos para el conteo de vocales en una lista de
 * palabras.
 * 
 * Incluye vocales normales y acentuadas (á, é, í, ó, ú, ü).
 * 
 */
public class Vocales {

    int numerovocales = 0;

    /**
     * Cuenta el total de vocales (normales y acentuadas) en una lista de palabras.
     * 
     * @param lista Lista de palabras a analizar
     * @return Número total de vocales encontradas
     */
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
