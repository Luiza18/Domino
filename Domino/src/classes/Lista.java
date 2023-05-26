package classes;

public class Lista {
    private Peca peca;
    private Lista prox;

    public Lista(Peca p){
        peca = p;
        prox = null;
    }

    public Peca getPeca() {
        return peca;
    }

    public Lista getProx() {
        return prox;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public void setProx(Lista prox) {
        this.prox = prox;
    }    
}