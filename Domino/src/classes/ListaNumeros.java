package classes;

public class ListaNumeros {
    private int index;
    private int[] vetor;

    public ListaNumeros(int tamanho) {
        vetor = new int[tamanho];
        index = 0;
    }

    public void add(int numero) {
        if (index < vetor.length) {
            vetor[index++] = numero;
        }
    }

    public int[] getVetor() {
        return vetor;
    }

    public boolean existencia(int num){
        boolean existe = false;

        for(int i =0; i < vetor.length; i++){
            if(vetor[i] == num){
                existe = true;
                break;
            }
        }

        return existe;
    }

}