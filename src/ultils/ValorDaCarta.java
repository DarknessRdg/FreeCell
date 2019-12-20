package ultils;


import java.util.HashMap;

public class ValorDaCarta {
    private static HashMap<String, Integer> MAPA_CARTAS = new HashMap<>();

    /**
     * Metodo para pegar um valor de uma carta em String
     * e convertê-lo para inteiro
     *
     * @param valor: valor da carta
     * @return int: inteiro que representa o numero do valor
     */
    public static int toInt(String valor) {
        MAPA_CARTAS.put("a", 1);
        MAPA_CARTAS.put("2", 2);
        MAPA_CARTAS.put("3", 3);
        MAPA_CARTAS.put("4", 4);
        MAPA_CARTAS.put("5", 5);
        MAPA_CARTAS.put("6", 6);
        MAPA_CARTAS.put("7", 7);
        MAPA_CARTAS.put("8", 8);
        MAPA_CARTAS.put("9", 9);
        MAPA_CARTAS.put("10", 10);
        MAPA_CARTAS.put("j", 11);
        MAPA_CARTAS.put("q", 12);
        MAPA_CARTAS.put("k", 13);

        return MAPA_CARTAS.get(valor);
    }
}
