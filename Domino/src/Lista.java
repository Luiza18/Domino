public class Lista {
    private Node head;

    public Lista(){
        head = null;
    }

    public void add(Peca p){
        if(head != null){
            head.push(p);
        }else{
            head = new Node(p);
        }
    }

    public void show(){
        if(head != null){
            head.show();
        }
    }

    public int size(){
        if(head!=null){
            return head.size();
        }
        else{
            return 0;
        }
    }

    public int [] tabela(){
        int tabela [] = new int[7];

        Node aux = head;

        while(aux != null){
            int esquerda = aux.getP().getEsquerda();
            int direita = aux.getP().getDireita();

            tabela[esquerda]++;
            tabela[direita]++;

            aux = aux.getProx();
        }

        return tabela;
    }

    public Node getHead() {
        return head;
    }

    public Peca verifica(int num){
        Node aux = head;

        while(aux != null){
            if(aux.getP().verificaNum(num)){
                return aux.getP();
            }else{
                aux = aux.getProx();
            }
        }
        return aux.getP();
    }

    public void remove(Peca peca) {
        if (head == null) {
            return; 
        }
    
        if (head.getP() == peca) {
            head = head.getProx(); 
            return;
        }
    
        Node previous = head;
        Node current = head.getProx();
    
        while (current != null) {
            if (current.getP() == peca) {
                previous.setProx(current.getProx()); 
                return;
            }
    
            previous = current;
            current = current.getProx();
        }
    }
}