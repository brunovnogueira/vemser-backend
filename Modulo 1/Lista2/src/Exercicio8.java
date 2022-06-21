import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Declarações
        int[][] matriz = new int[5][4];
        int matricula;
        int mediaProvas;
        int mediaTrabalhos;

        //Leitura da matrícula, média provas e média trabalhos
        for (int linha = 0;linha < 5; linha++){
            System.out.printf("Matricula %d° aluno: ",linha+1);
            matricula = sc.nextInt();
            matriz[linha][0] = matricula;

            System.out.printf("Média provas %d° aluno: ",linha+1);
            mediaProvas = sc.nextInt();
            matriz[linha][1] = mediaProvas;

            System.out.printf("Média trabalhos %d° aluno: ",linha+1);
            mediaTrabalhos = sc.nextInt();
            matriz[linha][2] = mediaTrabalhos;
        }

        //Cálculo notas finais
        for (int i = 0; i < 5; i++){
            matriz[i][3] = ((matriz[i][1] * 6) + (matriz[i][2] * 4)) / 10;
        }

        //Atribuindo a maior nota
        int maiorNota = 0;
        int matriculaMaiorNota = 0;
        for (int linha = 0; linha < 5; linha++){
            if (matriz[linha][3] > maiorNota){
                maiorNota = matriz[linha][3];
                matriculaMaiorNota = matriz[linha][0];
            }
        }

        int mediaNotasFinais = ((matriz[0][3]+matriz[1][3]+matriz[2][3]+matriz[3][3]+matriz[4][3]))/5;

        System.out.printf("A matrícula com a maior nota foi: %d%n",matriculaMaiorNota);
        System.out.printf("A média das notas finais foi: %d%n",mediaNotasFinais);
    }
}