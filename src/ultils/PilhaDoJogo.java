package ultils;

/**
 * Interface com os metodos obrigatorios para toda pilha do jogo
 */
public interface PilhaDoJogo {

    boolean podeEmpilhar(Carta carta);

    boolean estaOrdenadoApartirDe(int i);

    Carta get(int i);

    int indexOf(Carta carta);

    void empilha(Carta carta);

    Carta desempilha();

    int size();

}
