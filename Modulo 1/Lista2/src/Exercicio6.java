import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetorNumeros = {1,2,3,4,5,6,7,8,9,10};

        System.out.print("Número: ");
        int numeroBuscado = sc.nextInt();

        boolean numeroExiste = true;
        for(int valor : vetorNumeros){
            if (valor == numeroBuscado) {
                numeroExiste = true;
                break;
            }else {
                numeroExiste = false;
            }
        }

        if(numeroExiste){
            System.out.printf("O número %d existe no array.",numeroBuscado);
        }else {
            System.out.printf("O número %d não existe no array.",numeroBuscado);
        }
    }
}
