import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Lista pecas = new Lista();
        Tabuleiro tabuleiro;
        //String valores;

        System.out.println("*************************************************");
        System.out.println("Bem-vindo ao jogo do Dominó");
        System.out.println("*************************************************");
        System.out.println("Digite o número de peças e as peças");

        int n = scanner.nextInt();
        int k=0;

        while(k < n){
            System.out.println("\nAdicione o lado esquerdo da peça " + (k+1));
            int esquerda = scanner.nextInt();

            if(esquerda < 0 || esquerda > 6){
                System.out.println("ERRO: Adicione valores entre 0 e 6");
                break;
            }

            System.out.println("Adicione o lado direito da peça " + (k+1));
            int direita = scanner.nextInt();

            if(direita < 0 || direita > 6){
                System.out.println("ERRO: Adicione valores entre 0 e 6");
                break;
            }

            Peca peca = new Peca(esquerda, direita);
            pecas.add(peca);
            k++;
        }

        tabuleiro = new Tabuleiro(pecas);

        if(tabuleiro.verifica()){
            System.out.println("\nÉ possível formar uma sequência");
            tabuleiro.getResultado().show();
        }else{
            System.out.println("\nNão possível formar uma sequência");
        }
    }
}
