package classes;

public class Tabuleiro {
    private Peca pecas [];
    private int valores [] [];
    private ListaEncadeada resultado;

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
        resultado = new ListaEncadeada(null);
        int esquerda = -1;
        int direita = -1;

        for(int i =1; i < valores.length; i++){
            for(int j=0; j < valores[i].length; j++){
                ListaEncadeada prox = new ListaEncadeada(null);
                if(valores[i][j] != -1){
                    int index = valores[i][j];
                    Peca aux = pecas[index];
                    
                    if(resultado.getPeca() == null){
                        resultado.setPeca(aux);
                        resultado.setProx(prox);
                    }else{
                        esquerda = resultado.getPeca().getEsquerda();
                        direita = resultado.getPeca().getDireita();

                       if(aux.verificaNum(esquerda)){
                        prox.setPeca(aux);
                        resultado.setProx(prox);
                       }else if(aux.verificaNum(direita)){
                        aux.inverte();
                       }
                    }
                }
            }
        }
    

        return saida;
    }
    
}