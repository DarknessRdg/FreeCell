package ultils;

import java.util.ArrayList;

public class PilhaDeNaipes implements PilhaDoJogo {
    ArrayList<Carta> pilha;  // ArrayList que simulará a pilha

    public PilhaDeNaipes() { pilha = new ArrayList<>(); }

    /**
     * Metodo para pegar um elemento da pilha para alguma
     * manipulacao, mas isso nao remove da pilha
     * @param i: indice
     * @return Carta(): carta da posicao i
     */
    public Carta get(int i) { return pilha.get(i); }

    public int indexOf(Carta carta) { return pilha.indexOf(carta); }

    public int size() { return pilha.size(); }

    /**
     * Metodo para empilhar uma carta, porem nao faz
     * nenhuma verificacao antes de empilhar, apenas
     * empilha direto
     *
     * @param carta: carta que deseja empilhar
     */
    public void empilha(Carta carta) { pilha.add(carta); }

    /**
     * Metodo para desempilhar uma carta
     *
     * @return Carta(): carta do topo ou null caso vazia
     */
    public Carta desempilha() {
        // Pilha de naipes nao pode remover cartas
        return null;
    }

    /**
     * Metodo com a logica do jogo para poder empilhar
     * em uma pilha intermediaria
     *
     * @param carta: carta que deseja empilhar
     * @return boolean: se pode ou nao empilhar
     */
    public boolean podeEmpilhar(Carta carta) {

        if (size() == 0)
            return carta.getValor().equals("a");

        Carta ultima = get(pilha.size() - 1);

        return estaoOrdenadas(ultima, carta) &&
                ultima.getNaipe() == carta.getNaipe();
    }

    /**
     * Metodo privado com a regra  do jogo que analisa
     * se dada duas cartas, uma anterior e outra posterior
     * verifica se estão ordenadas de acordo com a regra
     * de uma pilha intermediaria
     *
     * @param anterior: carta anterior
     * @param posterior: carta posterior
     * @return boolean: se as duas cartas estao odenadas
     */
    private boolean estaoOrdenadas(Carta anterior, Carta posterior) {
        return ValorDaCarta.toInt(anterior.getValor()) + 1 == ValorDaCarta.toInt(posterior.getValor());
    }
}
