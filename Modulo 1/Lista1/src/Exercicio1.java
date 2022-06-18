import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        System.out.print("Digite sua cidade: ");
        sc.nextLine();
        String cidade = sc.nextLine();
        System.out.print("Digite o estado em que fica sua cidade: ");
        String estado = sc.nextLine();

        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.%n",
                nome,idade,cidade,estado);
    }
}
