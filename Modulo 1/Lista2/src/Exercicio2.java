import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroEscolhido = 5;
        int numeroAdivinhado;
        
        do{
            System.out.println("Escolha um número: ");
            numeroAdivinhado = sc.nextInt();
            
            if(numeroAdivinhado == numeroEscolhido){
                System.out.println("Parabéns, você acertou!");
            } else if (numeroAdivinhado < numeroEscolhido) {
                System.out.println("Errou! O número a ser encotrado é maior.");
            } else {
                System.out.println("Errou! O número a ser encotrado é menor.");
            }
        }while(numeroEscolhido != numeroAdivinhado);
    }
}
