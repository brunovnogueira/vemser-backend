import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Produto: ");
        String produto = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextInt();
        sc.nextLine();

        System.out.printf("Promoção: %s%n",produto);
        System.out.println("---------------------");

        double desconto = 0.05;
        for(int i=1; i<=10; i++){
            double precoDesconto = preco * (1-desconto);
            desconto += 0.05;
            System.out.printf("%d x R$ %.2f = R$ %.2f%n",i,precoDesconto,i*precoDesconto);
        }
    }
}
