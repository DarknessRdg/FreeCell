package ultils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Carta {
    private int naipe;
    private String valor;
    private String path;
    private int indicePilhaAtual;

    public Carta(int naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
        indicePilhaAtual = 0;
        setPath();
    }


    /* Sets */
    public void setIndicePilhaAtual(int indicePilhaAtual) {
        this.indicePilhaAtual = indicePilhaAtual;
    }

    private void setPath() {
        String pasta;
        switch (naipe) {
            case Naipes.COPAS:
                pasta = "copas";
                break;
            case Naipes.ESPADAS:
                pasta = "espadas";
                break;
            case Naipes.OUROS:
                pasta = "ouros";
                break;
            case Naipes.PAUS:
                pasta = "paus";
                break;
            default:
                pasta = "";
                break;
        }

        path = "cartas/"+pasta+"/"+valor+".png";
    }

    /* Gets */
    public int getNaipe() {
        return naipe;
    }

    public int getIndicePilha() {
        return indicePilhaAtual;
    }

    public String getValor() {
        return valor;
    }

    public ImageView getImage() {
        return new ImageView(new Image(path));
    }

    @Override
    public String toString() {
        return getValor() + " " + getNaipe();
    }

    /**
     * Verficar se duas cartas sao iguais
     *
     * @param other: outro objecto do tipo Carta()
     * @return boolean: se as cartas sao iguas
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Carta carta = (Carta) other;
        return naipe == carta.naipe &&
                valor.equals(carta.valor);
    }

    /**
     * Metodo estatico para pegar todas as cartas do baralho
     * e criar um objeto de cara uma
     *
     * @return ArrayList<Carta> com o baralho completo
     */
    public static ArrayList<Carta> loadCartas() {
        ArrayList<Carta> array = new ArrayList<>();

        array.addAll(loadCartas(Naipes.COPAS));
        array.addAll(loadCartas(Naipes.OUROS));
        array.addAll(loadCartas(Naipes.ESPADAS));
        array.addAll(loadCartas(Naipes.PAUS));

        return array;
    }

    private static ArrayList<Carta> loadCartas(int naipe) {
        ArrayList<Carta> array = new ArrayList<>();

        String valor;
        for (int i = 1; i <= Naipes.QNT_CARTAS_POR_NAIPE; i++) {
            valor = getValor(i);
            array.add(new Carta(naipe, valor));
        }

        return array;
    }

    private static String getValor(int i) {
        String valor;

        if (i == 1)
            valor = "a";

        else if (i >= 11) {
            if (i == 11)
                valor = "j";
            else if (i == 12)
                valor = "q";
            else
                valor = "k";
        }
        else
            valor = Integer.toString(i);

        return valor;
    }
}
