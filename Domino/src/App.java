import java.util.Scanner;
import classes.Peca;
import classes.Tabuleiro;
import classes.VetorPecas;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        VetorPecas listaPecas;
        Peca peca;
        Tabuleiro tabuleiro;
        //String valores;

        System.out.println("*************************************************");
        System.out.println("Bem-vindo ao jogo do Dominó");
        System.out.println("*************************************************");
        System.out.println("Digite o número de peças e as peças");

        int n = scanner.nextInt();
        listaPecas = new VetorPecas(n);
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


            peca = new Peca(esquerda, direita);
            listaPecas.add(peca);
            System.out.println("\nPeça: "+ peca.saidaPeca()+ " adicionada com sucesso\n");

            k++;
        }

        scanner.close();
        
        
        tabuleiro = new Tabuleiro(listaPecas);

        //tabuleiro.adiciona();
       int [][] valores = tabuleiro.getValores();
        

        for(int i=0; i < valores.length; i++){
            for(int j= 0; j < valores[i].length; j++){
                System.out.println(valores[i][j]);
            }
        }

         
    }
}