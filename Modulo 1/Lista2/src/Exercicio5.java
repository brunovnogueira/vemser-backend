import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetorNumeros = new int[20];

        for(int i = 0; i < 20; i++){
            System.out.printf("Digite o %d° número: ",i+1);
            int numero = sc.nextInt();
            vetorNumeros[i] = numero;
        }

        for(int i = vetorNumeros.length - 1;i >= 0; i-- ){
            System.out.print(vetorNumeros[i]+" ");
        }
    }
}
