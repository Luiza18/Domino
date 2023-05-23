package classes;

public class ConjuntoPecas {
    private int n;
    private Peca peca;
    private Lista conjunto; //numero de peças a serem inseridas
    private int index;

    public ConjuntoPecas(int n, Peca peca){
        this.n = n;
        this.peca = peca;
        index = 0;
    }

    public Lista getConjunto() {
        return conjunto;
    }

    public void setConjunto(Lista conjunto) {
        this.conjunto = conjunto;
    }

    public void adiciona(int esquerda, int direita){
        peca = new Peca(esquerda, direita);
        Lista aux = new Lista(peca);

        if(index == 0){
            conjunto.setX(peca);
        }
        if(index < n){
            conjunto.setProx(aux);
        }
    }

    // 
    

    //verifica os numeros existentes em cada peca
    public boolean verificaJogo(){
        int direitaInicial = conjunto.getX().getDireita();
        int esquerdaInicial = conjunto.getX().getEsquerda();
        int i=0;

       /*  while(i < n){
            if (( direitaInicial == conjunto.getProx().getX().getDireita() 
        || direitaInicial == conjunto.getProx().getX().getEsquerda())
        || esquerdaInicial == conjunto.getProx().getX().getEsquerda()
        || esquerdaInicial == conjunto.getProx().getX().getDireita()){
            int aux = 
        }
        }   */
        
        
        if(conjunto.getX().getPecaXY())
    }

    public void montarDomino(){
        if(verificaJogo()){

        }
    }
    // public void verifica(){
    //     int repitidos [] = new int [index];
    //     int unicos [] = new int [index];
    //     int k = 0;

    //     for(int i=0; i < index -1; i++){
    //        for(int j=1; i < index; j++){
    //             int inicio = conjunto[i].getInicio();
    //             int fim = conjunto[i].getFim();

    //             if (conjunto[j].verifica(inicio) || conjunto[j].verifica(fim)) {
    //                 if (!verificaNumero(repitidos, inicio) && !verificaNumero(repitidos, fim)) {
    //                     repitidos[k] = conjunto[j].verifica(inicio) ? inicio : fim;
    //                 }
    //             } else {
    //                 if (!verificaNumero(unicos, inicio) && !verificaNumero(unicos, fim)) {
    //                     unicos[k] = conjunto[j].verifica(inicio) ? inicio : fim;
    //                 }
    //             }                
    //         }
    //     }  
    // }
}