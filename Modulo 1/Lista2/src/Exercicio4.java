import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[3];

        for(int i = 0;i< numeros.length;i++){
            System.out.print("Digite um número: ");
            int numeroDigitado = sc.nextInt();
            numeros[i] = numeroDigitado;
        }

        if (numeros[0] < numeros[1] && numeros[0] < numeros[2]){
            System.out.println("O menor número está na posição 0");
        } else if (numeros[1] < numeros[2]) {
            System.out.println("O menor número está na posição 1");
        }else {
            System.out.println("O menor número está na posição 2");
        }
    }
}
