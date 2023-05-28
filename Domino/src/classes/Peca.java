public class Peca{
    private int esquerda;
    private int direita;
    private boolean usado;

    public Peca(int esquerda, int direita){
        this.esquerda = esquerda;
        this.direita = direita;
        usado = false;
    }

    public boolean getUsado(){
        return usado;
    }

    public void usar(){
        usado = true;
    }
    
    public int getDireita() {
        return direita;
    }

    public int getEsquerda() {
        return esquerda;
    }

    public void inverte(){
        int aux = direita;
        direita = esquerda;
        esquerda = aux;
    }

    public boolean verificaNum(int numero){
        return (numero == esquerda || numero == direita);
    }

    public String saidaPeca() {
        return esquerda + "|"+ direita + "|";
    }
}