package classes;

public class Tabuleiro {
    private int n;
    private Lista pecas,r,u, novoTopo; 
    private Lista conjunto = pecas;
    private Numeros repitidos, unicos;
    private int index;

    public Tabuleiro(int n){
        this.n = n;
        index = 0;
        repitidos = new Numeros(n);
        unicos = new Numeros(n);
    }

    public Lista getPecas() {
        return pecas;
    }

    public void setConjunto(Lista pecas) {
        this.pecas = pecas;
    }

    public void adiciona(Peca peca){
        novoTopo = new Lista(peca);
        int length = n;

        if(pecas.getX() == null){
            pecas.setX(peca);
            length--;
        }

        if(index < length){
            pecas.setProx(novoTopo);
            index ++;
        }
    }

    // tentar guarda a peça que tem o número            
    public void calcula(){
        int direita = conjunto.getX().getDireita();
        int esquerda = conjunto.getX().getEsquerda();

        if(conjunto.getProx() != null){
            if(conjunto.getProx().getX().verificaNum(esquerda) && !repitidos.verificaNumero(esquerda)){
                repitidos.add(esquerda);  
            }
            else if(!conjunto.getProx().getX().verificaNum(esquerda) && !unicos.verificaNumero(esquerda)){
                unicos.add(esquerda);
            }
            else if(conjunto.getProx().getX().verificaNum(direita) && !repitidos.verificaNumero(direita)){
                repitidos.add(direita);
            }
            else if(conjunto.getProx().getX().verificaNum(direita) && !unicos.verificaNumero(direita)){
                unicos.add(direita);
            }

            conjunto = conjunto.getProx(); 
            calcula();
        }else{
            if(!repitidos.verificaNumero(esquerda)){
                repitidos.add(esquerda);
            }else if(!repitidos.verificaNumero(direita)){
                repitidos.add(direita);
            }else if(!unicos.verificaNumero(direita)){
                unicos.add(direita);
            }else if(!unicos.verificaNumero(esquerda)){
                unicos.add(esquerda);
            }
        }
    }

    public boolean verifica(){
        return (repitidos.getIndex() > n -2);
    }  
}