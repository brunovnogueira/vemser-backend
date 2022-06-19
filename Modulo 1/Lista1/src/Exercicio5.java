import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---CÁLCULO DE SALARIO---");
        System.out.print("Informe o valor da hora (R$): ");
        double valorHora = sc.nextDouble();
        System.out.print("Quantidade de horas normais trabalhadas: ");
        int horasNormais = sc.nextInt();
        System.out.print("Quantidade de horas extras (50%): ");
        int horasExtras50 = sc.nextInt();
        System.out.print("Quantidade de horas extras (100%): ");
        int horasExtras100 = sc.nextInt();

        double salarioBruto = (horasNormais * valorHora) + (horasExtras50 * valorHora * 1.5) +
        (horasExtras100 * valorHora * 2);

        System.out.printf("O salário bruto é R$ %.2f",salarioBruto);
    }
}
