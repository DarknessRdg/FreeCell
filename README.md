# FreeCell
Trabalho3 da matéria de Estrutura de Dados


# Requirements

Antes de tentar executar, certifique-se de que de ter um Java 8+ e JavaFX instalado

# Get start

Execute o arquivo Main do diretório `` src/ Main/ Main.java ``

--- 

# O jogo

![tela do jogo](https://github.com/DarknessRdg/FreeCell/blob/master/tela%20do%20jogo.png)

**Regas:**

Ordem crescente das cartas: `` A - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - J - Q - K ``


**Pilhas intermerdiárias** *(8 pilhas inferiores)*

1. A pilha de cartas intermediárias só podem ser adicionadas se estiver em ordem decrescente e cor de naipes alternados.
2. Quando uma pilha intermediária ficar vazia, será possivel mover para ela somente se a carta tiver o valor "K".

**Pilhas vaizas** *(Canto superior esquerdo)*

3. Só é possível colocar 1 carta por vez.
4. Receber qualquer carta


**Pilhas definitivas** *(Canto superior direito)*

4. As pilhas definitivas devem ser odernadas em ordem crescente.
5. Só é possível adicionar na pilha definitiva se o naiper for igual.
6. Não é possível remover uma carta uma vez colocada na pilha definitiva

--- 

# Como mover as cartas

Para mover as cartas é preciso clicar na carta para selecioná-la e em seguida clicar no lugar que deseja movê-la.

Quando uma carta for clicada, ela deverá ficar com uma cor amarela ao redor indicando que ela foi selecionada. Ela só será desselecinada caso receber um clique sobre ela novamente.

A carta selecionada verá ficar como na imagem abaixo:

![carta selecionada](https://github.com/DarknessRdg/FreeCell/blob/master/carta%20selecionada.png)
