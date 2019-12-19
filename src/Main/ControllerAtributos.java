package Main;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ultils.Carta;
import ultils.PilhaIntermediaria;

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

    protected Carta cartaSelecionada = null;

    /*
     * Objeto de PilhaIntermediaria para cada pilha intermadiaria
     */
    protected PilhaIntermediaria pilha1 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha2 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha3 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha4 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha5 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha6 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha7 = new PilhaIntermediaria();
    protected PilhaIntermediaria pilha8 = new PilhaIntermediaria();


}
