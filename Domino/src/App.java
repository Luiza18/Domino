import java.util.Scanner;
import classes.Peca;
import classes.Tabuleiro;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Peca peca;
        Tabuleiro tabuleiro;
        String valores;
        int direita, esquerda;

        System.out.println("*************************************************");
        System.out.println("Bem-vindo ao jogo do Dominó");
        System.out.println("*************************************************");
        System.out.println("Digite o número de peças e as peças");

        int n = scanner.nextInt();
        //tabuleiro = new Tabuleiro(n);

         
        for (int i = 0; i < n; i++) {
            System.out.print("\nPeça " + (i + 1) + ": ");
            
            valores = scanner.next();

            esquerda =  valores.charAt(0);
            direita =  valores.charAt(1);

            if(esquerda > 6 || direita > 6){
                System.out.println("Os valores da peça não podem ser maior q 6!");
                i--;
            }else{
                peca = new Peca(esquerda, direita);
                //tabuleiro.adiciona(peca);
            }
        }

        scanner.close();
    }
}
