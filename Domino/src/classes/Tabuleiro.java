package classes;

public class Tabuleiro {
    private ListaNumeros unicos;
    private ListaPecas lista;
    private Peca pecas [];
    private int valores [] [];

    public Tabuleiro(ListaPecas lista){
       this.lista = lista;
       pecas = lista.getPecas();
       valores = new int [7][pecas.length];
       repitidos = new ListaNumeros(pecas.length);
    }

    public void pecasDomino(){
        for(int i =0; i< valores[0].length; i++){
            valores[0][i] = i;
        }
    }
    
    public void adiciona(){
        int linhas [] = valores[0];
        for(int i =0; i < pecas.length; i++){
            for(int coluna = 0; coluna < linhas.length; coluna ++){
                if(pecas[i].verificaNum(linhas[coluna])){
                    linhas[coluna] = i;
                }else{
                    unicos.add(linhas[coluna]);
                }
            }
        }
    }

    public boolean verifica(){
        return(unicos.getVetor().length < 3);
    }
    
}