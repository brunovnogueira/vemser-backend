import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double nota1,nota2,nota3,nota4;

        System.out.print("Digite a primeira nota: ");
        nota1 = sc.nextInt();
        System.out.print("Digite a segunda nota: ");
        nota2 = sc.nextInt();
        System.out.print("Digite a terceira nota: ");
        nota3 = sc.nextInt();
        System.out.print("Digite a quarta nota: ");
        nota4 = sc.nextInt();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media >= 0 && media <= 5){
            System.out.printf("A média foi: %.2f%n",media);
            System.out.println("REPROVADO");
        } else if (media >= 5.1 && media <= 6.9) {
            System.out.printf("A média foi: %.2f%n",media);
            System.out.println("EM EXAME");
        } else if (media >= 7 && media <= 10){
            System.out.printf("A média foi: %.2f%n",media);
            System.out.println("APROVADO");
        }else {
            System.out.printf("A média foi: %.2f%n",media);
            System.out.println("Valores de nota inválidos. As notas devem ser de 1 a 10");
        }
    }
}
