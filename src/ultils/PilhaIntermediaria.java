package ultils;

import java.util.ArrayList;

public class PilhaIntermediaria implements PilhaDoJogo {
    ArrayList<Carta> pilha;  // ArrayList que simulará a pilha

    public PilhaIntermediaria() { pilha = new ArrayList<>(); }

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
        if (pilha.size() != 0)
            return pilha.remove(pilha.size() - 1);
        else
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
        Carta ultima = get(pilha.size() - 1);

        return estaoOrdenadas(ultima, carta);
    }

    /**
     * Metodo para verificar se a pilha esta ordenada a
     * partir da posicao i
     *
     * @param i: indice da primeira carta para ser verificada
     * @return boolean: se a pilha esta ordenada a partir de i
     */
    public boolean estaOrdenadoApartirDe(int i) {
        if (i == pilha.size() - 1)  // ultima carta
            return true;

        Carta anterior = get(i);
        Carta posterior = get(i + 1);

        while (i < pilha.size() - 2 && estaoOrdenadas(anterior, posterior)) {
            i ++;
            anterior = get(i);
            posterior = get(i + 1);
        }

        System.out.println(anterior + "  " + posterior);

        return estaoOrdenadas(anterior, posterior);
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
        return ValorDaCarta.toInt(posterior.getValor()) + 1 == ValorDaCarta.toInt(anterior.getValor()) &&
                Naipes.saoDeCoresDiferentes(anterior.getNaipe(), posterior.getNaipe());
    }
}
