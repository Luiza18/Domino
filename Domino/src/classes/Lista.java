package classes;

public class Lista {
    private Peca peca;
    private Lista prox;
    private Lista ant;

    public Lista(Peca peca){
        this.peca = peca;
        prox = ant = null;
    }

    public Lista getAnt() {
        return ant;
    }

    public void setAnt(Lista ant) {
        this.ant = ant;
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