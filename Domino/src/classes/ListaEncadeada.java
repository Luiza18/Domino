package classes;

public class ListaEncadeada {
    private Peca peca;
    private ListaEncadeada prox;

    public ListaEncadeada(Peca p){
        peca = p;
        prox = null;
    }

    public Peca getPeca() {
        return peca;
    }

    public ListaEncadeada getProx() {
        return prox;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public void setProx(ListaEncadeada prox) {
        this.prox = prox;
    }    
}
