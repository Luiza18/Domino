package classes;

public class Tabuleiro {
    private Peca pecas [];
    private int tabela [] = new int[7];
    private int qtdUnicos;
    private int unicos[] = {-1,-1};
    private int repitidos [] = new int [7];
    private Lista resultado;
    private Lista ult;

    public Tabuleiro(VetorPecas lista){
       pecas = lista.getPecas();
       preencheTabela();
       qtdUnicos = 0;
      
    }

    private void preencheTabela(){
        for(int k =0; k < pecas.length; k++){
            for(int i =0; i < tabela.length; i++){
                if(pecas[k].verificaNum(i)){
                    if(pecas[k].pecaDupla()){
                        tabela[i] = tabela[i] + 2;
                    }else{
                        tabela[i]++;
                    }
                }
            }
        } 

        for(int i = 0; i < repitidos.length; i++){
            repitidos[i] = -1;
        }
    }

    private boolean verifica(){
        int maior = 1;
        int k =0;

        for(int i =0; i < tabela.length; i++){
            if(tabela[i] == 1){
                qtdUnicos++;
                if(unicos[0] != tabela[i]){
                    unicos[1] = tabela[i];
                }else{
                    unicos[0] = tabela[i];
                }
            }

            if(tabela[i] > maior){
                repitidos[k] = i;
                k++;
            }
        }
        return(qtdUnicos  < 3);
    }

    private void inicioSequencia(){
        int ultimo = -1;
        int inicio = -1;

        if(verifica()){
            if(qtdUnicos == 1){
               inicio = unicos[0]; 
            }else if(qtdUnicos == 2){
                inicio = unicos[0]; 
                ultimo = unicos[1];
            }


            for(int i =0; i < pecas.length; i++){
                if(inicio != -1){
                    if(pecas[i].verificaNum(inicio)){
                        if(pecas[i].getDireita() == inicio){
                            pecas[i].inverte();
                        }
                        resultado = new Lista(pecas[i]);
                    }
                }

                if(ultimo != -1){
                    if(pecas[i].verificaNum(ultimo)){
                        if(pecas[i].getEsquerda() == ultimo){
                            pecas[i].inverte();
                        }
                        ult = new Lista(pecas[i]);
                    }
                }
            }
        }
    }

    public void Sequencia(){
        inicioSequencia();
        Peca aux;
        
        for(int i =0; i < pecas.length; i++){
            if(resultado.getPeca() != null){
                aux = resultado.getPeca();
            }else{
              
            }
        }
    }
    
}