package Main;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import ultils.*;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;


/**
 * Controler do jogo
 */
public class Controller extends ControllerAtributos {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        embaralharCartas();
        distribuirCartas();
    }

    @FXML
    void addCopas(MouseEvent event) {
        if (cartaSelecionada != null && cartaSelecionada.getNaipe() == Naipes.COPAS)
            adicionarCartaNaPilhaDeNaipes(9);
    }
    @FXML
    void addEspadas(MouseEvent event) {
        if (cartaSelecionada != null && cartaSelecionada.getNaipe() == Naipes.ESPADAS)
            adicionarCartaNaPilhaDeNaipes(10);
    }
    @FXML
    void addOuros(MouseEvent event) {
        if (cartaSelecionada != null && cartaSelecionada.getNaipe() == Naipes.OUROS)
            adicionarCartaNaPilhaDeNaipes(11);
    }
    @FXML
    void addPaus(MouseEvent event) {
        if (cartaSelecionada != null && cartaSelecionada.getNaipe() == Naipes.PAUS)
            adicionarCartaNaPilhaDeNaipes(12);
    }

    /**
     * Metodo para embaralhar todas as caratas antes de
     * distribuir nas pilhas de cartas
     */
    private void embaralharCartas() {
        Collections.shuffle(CARTAS_EMBARALHADAS);
    }

    /**
     * Metodo para distribuir todas as cartas em cada pilha no inicio do jogo
     */
    private void distribuirCartas() {
        int pilha = 0;
        for (Carta carta: CARTAS_EMBARALHADAS) {
            pilha ++;
            carta.setIndicePilhaAtual(pilha);

            addCartaNaAnchoPane(carta);

            if (pilha == 8)
                pilha = 0;
        }
    }

    /**
     * Metodo para adicionar imagem de um carta
     * na pilha da carta
     * @param carta: Carta() que deseja adicionar
     */
    private void addCartaNaAnchoPane(Carta carta) {
        int pilhaDaCarta = carta.getIndicePilha();
        getPilha(pilhaDaCarta).empilha(carta);
        AnchorPane pane = getAnchorPaneDaPilha(pilhaDaCarta);

        int qntCartas = pane.getChildren().size();

        pane.getChildren().add(carta.getImage());

        Node newImage = pane.getChildren().get(qntCartas);
        if ((pane == copas || pane == ouros || pane == paus || pane == espadas)) {
            newImage.setLayoutY(0);
            newImage.setLayoutX(0);

            newImage.setOnMouseClicked(mouseEvent -> {
                // fazer nada ao clicar na imagem que esta
                // na pilha de naipes
            });
        } else {
            newImage.setLayoutY(qntCartas * 27);
            newImage.setEffect(getImageShadow());

            newImage.setOnMouseClicked(mouseEvent -> {
                clickCarta(carta);
            });
        }

    }

    /**
     * Metodo para remover uma carta de uma anchorPane e da pilha
     *
     * @param carta: carta a ser removida
     */
    private void removerCartaDaAnchoPane(Carta carta) {
        int pilhaDaCarta = carta.getIndicePilha();
        AnchorPane pane = getAnchorPaneDaPilha(pilhaDaCarta);

        int qntCartas = pane.getChildren().size();

        pane.getChildren().remove(pane.getChildren().size() - 1);
    }

    /**
     * Metodo com as regras do jogo para quando uma carta
     * receber um clique
     *
     * @param carta: carta clicada
     */
    private void clickCarta(Carta carta) {

        if (cartaSelecionada == null) {
            tentarSelecinarCarta(carta);

        } else if (carta == cartaSelecionada) {  // clicando sobre a carta para desselecionar
            desselecionarCarta();

        } else {
            tentarAdicionarCarta(carta);
        }
        System.out.println("Clicada: " + carta + "; selecionada: " + cartaSelecionada);
    }

    /**
     * Metodo com as regras do jogo para tentar selecinar  uma carta
     * quando nenhuma carta foi selecionada ainda
     *
     * @param carta: carta que recebeu o clique
     */
    private void tentarSelecinarCarta(Carta carta) {
        PilhaIntermediaria pilha = (PilhaIntermediaria) getPilha(carta.getIndicePilha());
        if (pilha.indexOf(carta) == pilha.size() - 1)  // se for a ultima
            selecionarCarta(carta);
        else {
            int index = pilha.indexOf(carta);

            if (pilha.estaOrdenadoApartirDe(index))
                selecionarCarta(carta);
        }
    }

    /**
     * Metodo com as regras do jogo para quando uma carta
     * clicada for a ultima, e ja tiver uma carta seleciona, em outras palavras,
     * jogador está tentando colocar a carta selecionada na nova pilha
     *
     * @param carta: carta que recebeu o clique
     */
    private void tentarAdicionarCarta(Carta carta) {
        if (carta.getIndicePilha() != cartaSelecionada.getIndicePilha()) {  // clicando em uma pilha diferente

            PilhaIntermediaria pilhaClicada = (PilhaIntermediaria) getPilha(carta.getIndicePilha());

            if (pilhaClicada.indexOf(carta) == pilhaClicada.size() - 1) { // clicando na ultima

                if (pilhaClicada.podeEmpilhar(cartaSelecionada)) {
                    // carta clicada é 1 antes da carta selecionada

                    adicionarCartaSelecionada(carta.getIndicePilha());
                }
            }
        }
    }

    /**
     * Metodo para adicionar 1 cara ou N cartas selecionadas em uma
     * pilha intermediaria dada o numero da pilha intermediaria
     *
     * @param numeroDaPilha: numero da pilha intermediaria que deseja adicionar
     */
    private void adicionarCartaSelecionada(int numeroDaPilha) {
        PilhaIntermediaria pilhaDeRemover = (PilhaIntermediaria) getPilha(cartaSelecionada.getIndicePilha());

        int index = pilhaDeRemover.indexOf(cartaSelecionada);

        PilhaIntermediaria pilhaAux = new PilhaIntermediaria();  // pilha pra inserir cartas removidas, pra
        // simular uma fila com duas pilhas

        Carta cartaRemovida;
        while (index < pilhaDeRemover.size() ) {
            System.out.println("size " + pilhaDeRemover.size());
            cartaRemovida = pilhaDeRemover.desempilha();
            pilhaAux.empilha(cartaRemovida);
        }

        int size = pilhaAux.size();
        for (int i = 0; i < size; i++) {
            cartaRemovida = pilhaAux.desempilha();

            removerCartaDaAnchoPane(cartaRemovida);
            cartaRemovida.setIndicePilhaAtual(numeroDaPilha);
            addCartaNaAnchoPane(cartaRemovida);
            desselecionarCarta();
        }
    }

    private void adicionarCartaNaPilhaDeNaipes(int numeroPilha) {
        if (cartaSelecionada != null) {
            PilhaIntermediaria pilhaDeRemover = (PilhaIntermediaria) getPilha(cartaSelecionada.getIndicePilha());
            if (pilhaDeRemover.indexOf(cartaSelecionada) == pilhaDeRemover.size() - 1) {  // esta tentando inserir
                // somente 1 carta

                PilhaDeNaipes pilha = (PilhaDeNaipes) getPilha(numeroPilha);

                if (pilha.podeEmpilhar(cartaSelecionada)) {
                    cartaSelecionada = pilhaDeRemover.desempilha();
                    cartaSelecionada.setIndicePilhaAtual(numeroPilha);

                    addCartaNaAnchoPane(cartaSelecionada);
                    desselecionarCarta();
                }

            }
        }
    }

    /**
     * Metodo para selecionar uma carta
     *
     * @param carta: carta selecionada
     */
    private void selecionarCarta(Carta carta) {
        cartaSelecionada = carta;

        DropShadow shadow = getImageShadow();
        shadow.setColor(Color.rgb(227, 198, 54));
        shadow.setHeight(shadow.getHeight() + 20);
        shadow.setWidth(shadow.getWidth() + 20);
        carta.getImage().setEffect(shadow);
    }

    /**
     * Metodo para descelecionar uma carta
     */
    private void desselecionarCarta() {
        if (cartaSelecionada != null)
            cartaSelecionada.getImage().setEffect(getImageShadow());
        cartaSelecionada = null;
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

    /**
     * Methodo para pegar anchor pane de acordo
     * com o numero da pilha
     *
     * @param pilhaDaCarta: numero da pilha
     * @return AnchorPane
     */
    private AnchorPane getAnchorPaneDaPilha(int pilhaDaCarta) {
        AnchorPane pane;
        switch (pilhaDaCarta) {

            // container das pilhas intermediarias
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
            case 8:
                pane = containerPilha8;
                break;

            // container das pilhas de naipes
            case 9:
                pane = copas;
                break;
            case 10:
                pane = espadas;
                break;
            case 11:
                pane = ouros;
                break;
            default:
                pane = paus;
                break;
        }
        return pane;
    }

    /**
     * Methodo para pegar ArrayList da pilha de acordo
     * com o numero da pilha
     *
     * @param pilhaDaCarta: numero da pilha
     * @return ArrayList<Carta>
     */
    private PilhaDoJogo getPilha(int pilhaDaCarta) {
        PilhaDoJogo pilha;
        switch (pilhaDaCarta) {
            // pilhas intermediarias
            case 1:
                pilha = pilha1;
                break;
            case 2:
                pilha = pilha2;
                break;
            case 3:
                pilha = pilha3;
                break;
            case 4:
                pilha = pilha4;
                break;
            case 5:
                pilha = pilha5;
                break;
            case 6:
                pilha = pilha6;
                break;
            case 7:
                pilha = pilha7;
                break;
            case 8:
                pilha = pilha8;
                break;

            // pilhas de naipes
            case 9:
                pilha = pilhaCopas;
                break;
            case 10:
                pilha = pilhaEspadas;
                break;
            case 11:
                pilha = pilhaOuros;
                break;
            default:
                pilha = pilhaPus;
                break;
        }
        return pilha;
    }

}