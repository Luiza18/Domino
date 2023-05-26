package classes;

public class Tabuleiro {
    private Peca pecas [];
    private int valores [] [];
    private Lista resultado;
    private int unicos [] = new int[2];
    private int numUnicos [] = new int[2];

    public Tabuleiro(VetorPecas lista){
       pecas = lista.getPecas();
       valores = new int [7][pecas.length+1];
       resultado = new Lista(null);
       preencheMatriz();
    }

    public int[][] getValores() {
        return valores;
    }

    private int [][] preencheMatriz(){
        for(int i=0; i < valores.length; i ++){
            for(int j=1; j < valores[i].length; j++){
                valores[i][j] = -1;
            }
        } 

        for(int i=0; i < 7; i++){
            valores[0][i] = i;
        }

        return valores;
    }
    
    public void adiciona(){
        int linhas [] = valores[0];
        for(int i =1; i < pecas.length; i++){
            for(int coluna = 0; coluna < linhas.length; coluna ++){
                if(pecas[i].verificaNum(linhas[coluna])){
                    linhas[coluna] = i;
                }
            }
        }
    }

    public boolean verifica(){
        int k = 0;
        boolean possivel = false;

        for(int i=1; i < 2 ; i++){
            for(int j =0; j <valores[i].length; j++){
                if(valores[i][j] == -1){
                    unicos[k++] = valores[i][j];
                    numUnicos[k++] = j;
                }
            }
        }

        if(k < 1){
            Lista aux = new Lista(pecas[unicos[k]]);
            possivel = true;
            if(pecas[unicos[0]].getEsquerda() != numUnicos[0]){
                pecas[unicos[0]].inverte();
            }

            if(k ==1){
                if(pecas[unicos[1]].getDireita() != numUnicos[0]){
                    pecas[unicos[1]].inverte();
                    resultado.setProx(aux);
                }
            }

            resultado.setPeca(pecas[unicos[0]]);
        }

        return possivel;
    }

    public void sequencia(){
        Peca ultima = null;
        int direita = -1;

        if(resultado.getProx().getPeca() != null){
            ultima = resultado.getProx().getPeca();
        }

        
        for(int i =1; i < valores.length; i++){
            for(int j=0; j < valores[i].length; j++){
                Lista prox = new Lista(null);

                if(valores[i][j] != -1){
                    int index = valores[i][j];
                    Peca aux = pecas[index];

                    if(resultado.getPeca() == null){
                        resultado.setPeca(aux);
                    }else{
                        direita = resultado.getPeca().getDireita();

                        if(aux.verificaNum(direita)){
                            if(aux.getDireita() == direita){
                                aux.inverte();
                            }
                            prox.setPeca(aux);
                            resultado.setProx(prox);
                        }
                    }
                    
                    resultado = resultado.getProx();
                }
            }
        }
    
        if(resultado.getProx().getPeca() != ultima){
            Lista ult = new Lista(ultima);
            resultado.setProx(ult);
        }
    }
    
}