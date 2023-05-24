package classes;

public class Peca {
    private int esquerda;
    private int direita;

    public Peca(int esquerda, int direita){
        this.esquerda = esquerda;
        this.direita = direita;
    }
    
    public int getDireita() {
        return direita;
    }

    public int getEsquerda() {
        return esquerda;
    }

    public Peca(){}

    public void inverte(){
        int aux = direita;
        direita = esquerda;
        esquerda = aux;
    }

    //verifica se o numero passado existe na peça atual
    public boolean verificaNum(int numero){
        return (numero == esquerda || numero == direita);
    }

    public String saidaPeca() {
        return direita + "|"+ esquerda + "|";
    }
}
