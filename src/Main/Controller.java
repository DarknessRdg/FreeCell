package Main;


import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import ultils.Carta;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;


/**
 * Controler do jogo
 */
public class Controller extends ControllerAtributos {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        embararCartas();
        distribuirCartas();
    }

    /**
     * Metodo para embaralhar todas as caratas antes de
     * distribuir nas pilhas de cartas
     */
    private void embararCartas() {
        Collections.shuffle(CARTAS_EMBARALHADAS);
    }

    /**
     * Metodo para distribuir todas as cartas em cada pilha no inicio do jogo
     */
    private void distribuirCartas() {
        int pilha = 0;
        for (Carta carta: CARTAS_EMBARALHADAS) {
            pilha ++;

            addCartaNaPilha(pilha, carta);

            if (pilha == 8)
                pilha = 0;
        }
    }

    /**
     * Metodo para adicionar imagem de um carta
     * na pilha desejada
     * @param i: inteiro com o numero da posicao da pilha
     * @param carta: Carta() que deseja adicionar
     */
    private void addCartaNaPilha(int i, Carta carta) {
        AnchorPane pane;
        switch (i) {
            case 1:
                pane = containerPilha1;
                break;
            case 2:
                pane = containerPilha2;
                break;
            case 3:
                pane = containerPilha3;
                break;
            case 4:
                pane = containerPilha4;
                break;
            case 5:
                pane = containerPilha5;
                break;
            case 6:
                pane = containerPilha6;
                break;
            case 7:
                pane = containerPilha7;
                break;
            default:
                pane = containerPilha8;
                break;
        }

        Node ultimo = null;
        int size = pane.getChildren().size();

        if (size != 0)
            ultimo = pane.getChildren().get(size - 1);

        pane.getChildren().add(carta.getImage());

        Node newImage = pane.getChildren().get(size);
        newImage.setLayoutY(size * 27);
        newImage.setEffect(getImageShadow());
    }

    /**
     * Metodo para cria um drop shadow para o container
     * da imagem da carta
     *
     * @return DropShadow()
     */
    private DropShadow getImageShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(0);
        shadow.setOffsetY(2);
        shadow.setHeight(25);
        shadow.setColor(Color.rgb(0,0,0,0.4));
        return shadow;
    }
}