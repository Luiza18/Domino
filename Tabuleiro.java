public class Tabuleiro {
    private Lista pecas;
    private Lista resultado;
    private int vetorUnicos [] = new int[unicos()];

    public Tabuleiro(Lista pecas){
        this.pecas = pecas;
    }

    private int unicos(){
        int vetor [] = pecas.tabela();
        int qtd = 0;

        for(int i =0; i < vetor.length; i++){
            if(vetor[i] ==1){
                vetorUnicos[qtd] = vetor[i];
                qtd++;
            }
        }
        return qtd;
    }

    public int qtdNumero(){
        int vetor [] = pecas.tabela();
        int qtd = 0;

        for(int i =0; i < vetor.length; i++){
            if(vetor[i] != 0){
                qtd++;
            }
        }
        return qtd;
    }

    public boolean verifica(){
        return(pecas.size() == qtdNumero() || unicos() < 3);
    }

   public int maisRepete(){
    int vetor [] = pecas.tabela();
    int maior = vetor[0];

    for(int i =0; i < vetor.length; i++){
        if(vetor[i] > maior){
            maior = vetor[i];
        }
    }

    return maior;
   }

   public void sequencia(){
    Peca primeira = null; 
    Peca ultima = null;

        if(unicos() > 0){
            if(unicos() == 2){
                ultima = pecas.verifica(vetorUnicos[1]);
            }

            primeira = pecas.verifica(vetorUnicos[0]);
        }

        if(primeira != null){
            resultado.add(primeira);
        }else{
            Peca aux = pecas.verifica(maisRepete());
            resultado.add(aux);
        }

        while(resultado.size() <= pecas.size()){
            int direita = resultado.getHead().getP().getDireita();

            Peca aux = pecas.verifica(direita);
            if(aux.getDireita() == direita){
                aux.inverte();
            }
            resultado.add(aux);
        }
   }

   public Lista getResultado() {
       return resultado;
   }
}
