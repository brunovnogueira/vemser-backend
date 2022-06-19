import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva sua idade em anos, meses e dias:");
        System.out.print("ANOS: ");
        int anos = sc.nextInt();
        System.out.print("MESES: ");
        int meses = sc.nextInt();
        System.out.print("DIAS: ");
        int dias = sc.nextInt();

        int idadeTotal = (anos * 365) + (meses * 30) + dias;

        System.out.printf("A idade total em dias é: %d dias.%n",idadeTotal);
    }
}
