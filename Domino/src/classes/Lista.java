package classes;

public class Lista {
        private Peca x;
        private Lista prox;
        
        public Lista(Peca v){
            x = v;
            prox = null;
        }
        
        public void setX(Peca v){
            x = v;
        }
        
        public Peca getX(){
            return x;
        }
        
        public void setProx(Lista p){
            prox = p;
        }
        
        public Lista getProx(){
            return prox;
        }  
}