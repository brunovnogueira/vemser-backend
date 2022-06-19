import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Total de eleitores: ");
        double totalEleitores = sc.nextInt();
        System.out.print("Votos em branco: ");
        double votosBranco = sc.nextInt();
        System.out.print("Votos nulo: ");
        double votosNulo = sc.nextInt();
        System.out.print("Votos válidos: ");
        double votosValido = sc.nextInt();

        double porcentagemBranco = (votosBranco/totalEleitores) * 100;
        double porcentagemNulo = (votosNulo/totalEleitores) * 100;
        double porcentagemValido = (votosValido/totalEleitores) * 100;

        System.out.printf("Porcentagem de votos em branco: %.2f%n",porcentagemBranco);
        System.out.printf("Porcentagem de votos nulos: %.2f%n",porcentagemNulo);
        System.out.printf("Porcentagem de votos válidos: %.2f%n",porcentagemValido);
    }
}
