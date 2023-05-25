package classes;

public class Tabuleiro {
    private Peca pecas [];
    private int valores [] [];

    public Tabuleiro(ListaPecas lista){
       pecas = lista.getPecas();
       pecas = lista.getPecas();
       valores = new int [7][pecas.length];
    }

    public void pecasDomino(){
        for(int i =0; i< valores[0].length; i++){
            valores[0][i] = i;
        }

        for(int i=0; i < valores.length; i ++){
            for(int j=1; j < valores[i].length; j++){
                valores[i][j] = -1;
            }
        }
        
    }
    
    public void adiciona(){
        int linhas [] = valores[0];
        for(int i =0; i < pecas.length; i++){
            for(int coluna = 0; coluna < linhas.length; coluna ++){
                if(pecas[i].verificaNum(linhas[coluna])){
                    linhas[coluna] = i;
                }
            }
        }
    }

    public int unicos(){
        int qtd = 0;

        for(int i=1; i < 2 ; i++){
            for(int j =0; j <valores[i].length; j++){
                if(valores[i][j] == -1){
                    qtd ++;
                }
            }
        }

        return qtd;
    }

    public boolean verifica(){
        return(unicos() < 3);
    }

    public String sequencia(){
        String saida = "";

        

        return saida;
    }
    
}