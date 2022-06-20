import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Declaração de variáveis
        double alturaJogador;
        int idadeJogador;
        double pesoJogador;
        double maiorAltura = 0;
        double maiorIdade = 0;
        double maiorPeso = 0;
        String jodagorMaisVelho = "";
        String jogadorMaisPesado = "";
        double somaAltura = 0;
        int quantidade = 0;

        //Loop
        System.out.print("Nome: ");
        String nomeJogador = sc.nextLine();
        while(!nomeJogador.equals("fim")){
            System.out.print("Altura: ");
            alturaJogador = sc.nextDouble();
            sc.nextLine();
            System.out.print("Idade: ");
            idadeJogador = sc.nextInt();
            sc.nextLine();
            System.out.print("Peso: ");
            pesoJogador = sc.nextDouble();
            sc.nextLine();

            if (idadeJogador > maiorIdade){
                jodagorMaisVelho = nomeJogador;
                maiorIdade = idadeJogador;
            }

            if (pesoJogador > maiorPeso){
                jogadorMaisPesado = nomeJogador;
                maiorPeso = pesoJogador;
            }

            if (alturaJogador > maiorAltura){
                maiorAltura = alturaJogador;
            }

            quantidade += 1;
            somaAltura += alturaJogador;

            System.out.print("Nome: ");
            nomeJogador = sc.nextLine();
        }

        //Cáclculo média de alturas
        double mediaAltura = somaAltura/quantidade;

        //Saída de dados
        System.out.println("---------------------------------------");
        System.out.println("Quantidade de cadastros: "+quantidade);
        System.out.println("Maior altura: "+maiorAltura);
        System.out.println("Jogador mais velho: "+ jodagorMaisVelho);
        System.out.println("Jogador mais pesado: "+ jogadorMaisPesado);
        System.out.printf("Média das alturas: %.2f%n",mediaAltura);
    }
}
