public class Tabuleiro {
    private Lista pecas;
    private Lista resultado;
    private Peca primeira, ultima;
    private int qtdNumeros = 0;
    private int qtdUnicos = 0;
    private int[] numerosUnicos = new int[2];
    private int maior;
    
    public Tabuleiro(Lista pecas) {
        this.pecas = pecas;
        resultado = new Lista();
        analiseNumeros();
        procuraUnicos();
    }
    
    private void analiseNumeros() {
        int[] tabela = pecas.tabela();
        maior = 0;
    
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == 1) {
                qtdUnicos++;
            }
    
            if (tabela[i] != 0) {
                qtdNumeros++;
            }
    
            if (tabela[i] > tabela[maior]) {
                maior = i;
            }
        }
    }
    
    public void procuraUnicos() {
        if (qtdUnicos > 0) {
            int[] tabela = pecas.tabela();
            int k = 0;
    
            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i] == 1) {
                    numerosUnicos[k] = i;
                    k++;
                }
            }
        }
    }
    
    public boolean verifica(){
        return(qtdNumeros < pecas.size() + qtdUnicos && qtdUnicos< 3);
    }

    private void inicioSequencia(){
        primeira = null; 
        ultima = null;
        int direita = 0;
        int tamanho = pecas.size();
    
            if(qtdUnicos > 0){
                if(qtdUnicos == 2){
                    ultima = pecas.verifica(numerosUnicos[1]);
                    if(ultima.getEsquerda() == numerosUnicos[1]){
                        ultima.inverte();
                    }
                    pecas.remove(ultima);
                }
                primeira = pecas.verifica(numerosUnicos[0]);
            }
    
            if (primeira != null) {
                if (primeira.getDireita() == numerosUnicos[0]) {
                    primeira.inverte();
                }
            }else{
                primeira = pecas.verifica(maior);
                if (primeira != null) {
                    if (primeira.getEsquerda() == maior) {
                        primeira.inverte();
                    }
                }
            }
            
            resultado.add(primeira);
            pecas.remove(primeira);

    }
    
    private void sequenciaRepitidos(){
        inicioSequencia();

        while(pecas.size() > 0){
            int direita = resultado.ultimaPeca().getP().getDireita();

            Peca aux = pecas.verifica(direita);

            if(aux.getDireita() == direita){
                aux.inverte();
            }
            resultado.add(aux);
            pecas.remove(aux);
        }
    }

    private void sequenciaUnicos(){
        int numeroUltima = ultima.getEsquerda();

        while(pecas.size() > 0){
            
        }
    }

    public void sequencia(){
        if(qtdUnicos != 2){
            sequenciaRepitidos();
        }else{
            sequenciaUnicos();
        }
    }
        
   public Lista getResultado() {
       return resultado;
   }

   public Lista getPecas() {
       return pecas;
   }
}