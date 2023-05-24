package classes;

public class Numeros {
    private int index;
    private int [] vetor; 

    public Numeros(int tamanho){
        vetor = new int[tamanho];
        index = 0;
    }

    public int[] getVetor() {
        return vetor;
    }

    public int getIndex() {
        return index;
    }

    public void add(int numero){
        if(index < vetor.length){
            vetor[index++] = numero;
        }
    }

    public boolean verificaNumero(int numero){
        boolean achou = false;

        for(int i=0; i < index; i++){
            if(vetor[i] == numero){
                achou = true;
                break;
            }
        }

        return achou;
    }
}