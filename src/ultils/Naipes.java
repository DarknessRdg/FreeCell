package ultils;


/**
 * Classe com as constantes dos Naipes do baralho
 */
public class Naipes {
    public static final int COPAS = 1;
    public static final int ESPADAS = 2;
    public static final int OUROS = 3;
    public static final int PAUS = 4;
    public static final int QNT_CARTAS_POR_NAIPE = 13;


    /**
     * Metodo para verificar se dodos dois naipes
     * sao contrario, ou seja, se sao de cores
     * diferentes
     *
     * @param naipe1: numero do naipe1
     * @param naipe2: numero do naipe2
     * @return boolean: se eles possuem cores diferentes
     */
    static boolean saoDeCoresDiferentes(int naipe1, int naipe2) {
        // cores vermelhas sao impares
        // cores pretas sao pares
        boolean ehPar1 = naipe1 % 2 == 0;
        boolean ehPar2 = naipe2 % 2 == 0;

        return ehPar1 != ehPar2;
    }
}
