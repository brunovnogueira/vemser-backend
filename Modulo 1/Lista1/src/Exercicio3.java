import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor consumido: ");
        double valorConsumido = sc.nextDouble();

        System.out.print("Valor pago: ");
        double valorPago = sc.nextDouble();

        if (valorPago < valorConsumido){
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        } else{
            double troco = valorPago - valorConsumido;
            System.out.printf("O troco é R$ %.2f",troco);
        }
    }
}
