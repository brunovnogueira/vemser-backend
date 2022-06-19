import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Você quer traduzir PT-br para EN (1) ou EN para PT-br (2)? ");
        int escolhaTraducao = sc.nextInt();

        if (escolhaTraducao == 1){
            System.out.println("Cachorro");
            System.out.println("Tempo");
            System.out.println("Amor");
            System.out.println("Cidade");
            System.out.println("Feliz");
            System.out.println("Triste");
            System.out.println("Deveria");
            System.out.println("Poderia");
            System.out.print("Qual das palavras acima você quer traduzir? ");
            sc.nextLine();
            String palavra = sc.nextLine();

            switch (palavra){
                case "Cachorro":
                    System.out.println("TRADUÇÃO: Dog");
                    break;
                case "Tempo":
                    System.out.println("TRADUÇÃO: Time");
                    break;
                case "Amor":
                    System.out.println("TRADUÇÃO: Love");
                    break;
                case "Cidade":
                    System.out.println("TRADUÇÃO: City");
                    break;
                case "Feliz":
                    System.out.println("TRADUÇÃO: Happy");
                    break;
                case "Triste":
                    System.out.println("TRADUÇÃO: Sad");
                    break;
                case "Deveria":
                    System.out.println("TRADUÇÃO: Should");
                    break;
                case "Poderia":
                    System.out.println("TRADUÇÃO: Could");
                    break;
                default:
                    System.out.println("Essa palavra não é válida.");
                    break;
            }
        } else if (escolhaTraducao == 2) {
            System.out.println("Dog");
            System.out.println("Time");
            System.out.println("Love");
            System.out.println("City");
            System.out.println("Happy");
            System.out.println("Sad");
            System.out.println("Should");
            System.out.println("Could");
            System.out.print("Qual das palavras acima você quer traduzir? ");
            sc.nextLine();
            String palavra = sc.nextLine();

            switch (palavra) {
                case "Dog":
                    System.out.println("TRADUÇÃO: Cachorro");
                    break;
                case "Time":
                    System.out.println("TRADUÇÃO: Tempo");
                    break;
                case "Love":
                    System.out.println("TRADUÇÃO: Amor");
                    break;
                case "City":
                    System.out.println("TRADUÇÃO: Cidade");
                    break;
                case "Happy":
                    System.out.println("TRADUÇÃO: Feliz");
                    break;
                case "Sad":
                    System.out.println("TRADUÇÃO: Triste");
                    break;
                case "Should":
                    System.out.println("TRADUÇÃO: Deveria");
                    break;
                case "Could":
                    System.out.println("TRADUÇÃO: Poderia");
                    break;
                default:
                    System.out.println("Essa palavra não é válida.");
                    break;
            }
        }
    }
}
