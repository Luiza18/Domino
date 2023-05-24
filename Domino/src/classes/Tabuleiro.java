package classes;

public class Tabuleiro {
    private int n;
    private Peca peca;
    private Lista pecas; 
    private Lista conjunto = pecas;
    private int index;
    private int indexRepitidos;
    private int [] repitidos = new int[index];

    public Tabuleiro(int n, Peca peca){
        this.n = n;
        this.peca = peca;
        index = indexRepitidos = 0;
    }

    public Lista getPecas() {
        return pecas;
    }

    public void setConjunto(Lista pecas) {
        this.pecas = pecas;
    }

    public void adiciona(int esquerda, int direita){
        peca = new Peca(esquerda, direita);
        Lista novoTopo = new Lista(peca);
        int length = n;

        if(pecas.getX() == null){
            pecas.setX(peca);
            length--;
        }

        if(index < length){
            pecas.setProx(novoTopo);
            index ++;
        }
    }

    public void addRepitidos(int num){
        if(indexRepitidos < repitidos.length){
            repitidos[indexRepitidos++] = num;
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

    public void calcula(){
        int direita = conjunto.getX().getDireita();
        int esquerda = conjunto.getX().getEsquerda();

        if(conjunto.getProx() != null){
            if(conjunto.getProx().getX().verificaNum(esquerda) && !verificaRepitidos(esquerda)){
                addRepitidos(esquerda);
            }else if(conjunto.getX().verificaNum(direita) && !verificaRepitidos(direita)){
                addRepitidos(direita);
            }

            conjunto = conjunto.getProx(); 
            calcula();
        }else{
            if(!verificaRepitidos(esquerda)){
                addRepitidos(esquerda);
            }else if(!verificaRepitidos(direita)){
                addRepitidos(direita);
            }
        }
    }

    public boolean verifica(){
        return (repitidos.length > n -2);
    }   
}