package classes;

public class ListaPecas {
    private int index;
    private Peca pecas [];

    public ListaPecas(int tamanho){
        pecas = new Peca [tamanho];
        index = 0;
    }

    public void add(Peca peca){
        if(index < pecas.length){
            pecas[index++] = peca;
        }
    }

    public Peca[] getPecas() {
        return pecas;
    }
}