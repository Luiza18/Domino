public class Node {
    private Peca p;
    private Node prox;

    public Node(Peca p){
        this.p = p;
        prox = null;
    }

    public void push(Peca p){
        if(prox != null){
            prox.push(p);
        }else{
            prox = new Node(p);
        }
    }

    public void show(){
        System.out.println(p.saidaPeca());
        if(prox != null){
            prox.show();
        }
    }

    public int size(){
        int s;
        if(prox!=null){
            s = prox.size();
        }
        else{
            s = 0;
        }
        return s+1;
    }

    public Peca getP() {
        return p;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }
}