import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua data de aniversário? ");
        LocalDate dtAniversario = LocalDate.parse(sc.nextLine());
        LocalDate now = LocalDate.now();
        if (now.isAfter(dtAniversario.withYear(now.getYear()))){
            Period periodo = Period.between(now,dtAniversario.withYear(now.plusYears(1).getYear()));
            System.out.println("FALTAM "+periodo.getDays()+" DIAS E "+periodo.getMonths()+" MESES PARA SEU ANIVERÁRIO!");
        }else {
            Period periodo = Period.between(now,dtAniversario.withYear(now.getYear()));
            System.out.println("FALTAM "+periodo.getDays()+" DIAS E "+periodo.getMonths()+" MESES PARA SEU ANIVERÁRIO!");
        }
    }
}
