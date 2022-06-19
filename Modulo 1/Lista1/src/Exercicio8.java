import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a base do retangulo: ");
        double base = sc.nextDouble();
        System.out.print("Digite a altura do retangulo: ");
        double altura = sc.nextDouble();

        double area = base * altura;

        System.out.printf("A área do retangulo é: %.2f%n",area);
    }
}
