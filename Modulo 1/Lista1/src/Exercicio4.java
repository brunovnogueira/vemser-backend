import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - São Paulo");
        System.out.println("2 - Rio Grande do Sul");
        System.out.println("3 - Bahia");
        System.out.print("Escolha o número de um dos estados acima: ");
        int escolhaEstado = sc.nextInt();

        int escolhaCidade = 0;
        switch (escolhaEstado){
            case 1:
                System.out.println("1 - Santos");
                System.out.println("2 - Campinas");
                System.out.print("Escolha o número de uma das cidades acima: ");
                escolhaCidade = sc.nextInt();
                break;
            case 2:
                System.out.println("1 - Porto Alegre");
                System.out.println("2 - Canoas");
                System.out.print("Escolha o número de uma das cidades acima: ");
                escolhaCidade = sc.nextInt();
                break;
            case 3:
                System.out.println("1 - Salvador");
                System.out.println("2 - Porto Seguro");
                System.out.print("Escolha o número de uma das cidades acima: ");
                escolhaCidade = sc.nextInt();
                break;
        }

        if (escolhaEstado == 1 && escolhaCidade == 1){
            System.out.println("---SANTOS---");
            System.out.println("População: 433.656");
            System.out.println("IDH: 0,84");
        } else if (escolhaEstado == 1 && escolhaCidade == 2) {
            System.out.println("---CAMPINAS---");
            System.out.println("População: 1.223.237");
            System.out.println("IDH: 0,80");
        } else if (escolhaEstado == 2 && escolhaCidade == 1) {
            System.out.println("---PORTO ALEGRE---");
            System.out.println("População: 1.492.530");
            System.out.println("IDH: 0,80");
        } else if (escolhaEstado == 2 && escolhaCidade == 2) {
            System.out.println("---CANOAS---");
            System.out.println("População: 349.728");
            System.out.println("IDH: 0,75");
        } else if (escolhaEstado == 3 && escolhaCidade == 1) {
            System.out.println("---SALVADOR---");
            System.out.println("População: 2.675.656");
            System.out.println("IDH: 0,75");
        } else if (escolhaEstado == 3 && escolhaCidade == 2) {
            System.out.println("---PORTO SEGURO---");
            System.out.println("População: 152.529");
            System.out.println("IDH: 0,67");
        }
    }
}
