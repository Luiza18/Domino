package classes;

public class Tabuleiro {
    private int n;
    private Peca peca;
    private Lista conjunto; 
    private int index;
    private int [] repitidos = new int[index];

    public Tabuleiro(int n, Peca peca){
        this.n = n;
        this.peca = peca;
        index = 0;
    }

    public Lista getConjunto() {
        return conjunto;
    }

    public void setConjunto(Lista conjunto) {
        this.conjunto = conjunto;
    }

    public void adiciona(int esquerda, int direita){
        peca = new Peca(esquerda, direita);
        Lista aux = new Lista(peca);

        if(index == 0){
            conjunto.setX(peca);
        }
        if(index < n){
            conjunto.setProx(aux);
        }
    }

    public boolean verificaRepitidos(int num){
        boolean retorno = false;

        for(int i=0; i < repitidos.length; i++){
            if(repitidos[i] == num){
                retorno = true;
                break;
            }
        }

        return retorno;
    }

    public int verifica(){
        int direitaInicial = conjunto.getX().getDireita();
        int esquerdainicial = conjunto.getX().getEsquerda();
        int k = 0;

        Peca aux = conjunto.getProx().getX();

        if (aux.verificaNum(esquerdainicial) && !verificaRepitidos(esquerdainicial)) {
            repitidos[k] = esquerdainicial;
            k++;
        } else if (aux.verificaNum(direitaInicial) && !verificaRepitidos(direitaInicial)) {
            repitidos[k] = direitaInicial;
            k++;
        }

        return repitidos.length; 
    }

    /*
     OBS: 
        1 - Se verifica() < n -2, então não é posível fazer o sequenciamento, senão é possível
        2 - A Lista de peça vai ser uma Lista encadeada que funciona como uma pilha
            2.1 - Com isso, vai ser possível fazer o 'loop' para fazer a verificação de cada peça
        3 - Se o verifica() = n - 2, é pq existem 2 números q são únicos, logo, 
            as peças que possuem números únicos devem ficar na ponta do sequenciamento
                3.1 - Será vale a pena construir um vetor de números únicos ?
     */
    
}