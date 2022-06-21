public class Exercicio7 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int contador = 0;
        for (int linha = 0;linha < 4; linha++){
            for (int coluna = 0;coluna < 4; coluna++ ){
                if (matriz[linha][coluna] > 10){
                    contador += 1;
                }
            }
        }

        System.out.printf("Existem %d números maiores que 10.", contador);
    }
}
