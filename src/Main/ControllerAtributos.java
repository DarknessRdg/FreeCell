package Main;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ultils.Carta;

import java.util.ArrayList;


/**
 * Calsse Abstrata com todos os atributos necessarios para o jogo
 */
public abstract  class ControllerAtributos implements Initializable {

    /*
     * JavaFx ID para as 4 areas vazias que poderam receber uma carta
     */
    @FXML
    protected AnchorPane vazia1;
    @FXML
    protected AnchorPane vazia2;
    @FXML
    protected AnchorPane vazia3;
    @FXML
    protected AnchorPane vazia4;

    /*
     * JavaFx ID para as 4 pilhas de naipes
     */
    @FXML
    protected AnchorPane ouros;
    @FXML
    protected AnchorPane copas;
    @FXML
    protected AnchorPane paus;
    @FXML
    protected AnchorPane espadas;

    /*
     * JavaFx ID para as 8 pilhas de cartas aleatorias
     */
    @FXML
    protected AnchorPane containerPilha1;
    @FXML
    protected AnchorPane containerPilha2;
    @FXML
    protected AnchorPane containerPilha3;
    @FXML
    protected AnchorPane containerPilha4;
    @FXML
    protected AnchorPane containerPilha5;
    @FXML
    protected AnchorPane containerPilha6;
    @FXML
    protected AnchorPane containerPilha7;
    @FXML
    protected AnchorPane containerPilha8;

    /*
     * Utilitarios para o jogo
     */
    protected ArrayList<Carta> CARTAS_EMBARALHADAS = Carta.loadCartas();

    /*
     * Pilha com os objetos de cartas de cada
     * continer de pilha
     */
    protected ArrayList<Carta> pilha1;
    protected ArrayList<Carta> pilha2;
    protected ArrayList<Carta> pilha3;
    protected ArrayList<Carta> pilha4;
    protected ArrayList<Carta> pilha5;
    protected ArrayList<Carta> pilha6;
    protected ArrayList<Carta> pilha7;
    protected ArrayList<Carta> pilha8;

}
