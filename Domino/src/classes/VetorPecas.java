package classes;

public class VetorPecas {
    private int index;
    private Peca pecas [];

    public VetorPecas(int tamanho){
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

    public void setPecas(Peca[] pecas) {
        this.pecas = pecas;
    }

}