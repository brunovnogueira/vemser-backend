import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a primeira data: ");
        LocalDate dt1 = LocalDate.parse(sc.nextLine());
        System.out.println("Informe a segunda data: ");
        LocalDate dt2 = LocalDate.parse(sc.nextLine());
        if (dt1.isBefore(dt2)){
            long diffDias = ChronoUnit.DAYS.between(dt1,dt2);
            long diffMes = ChronoUnit.MONTHS.between(dt1,dt2);
            long diffAno = ChronoUnit.YEARS.between(dt1,dt2);
            System.out.println("DIAS: "+diffDias);
            System.out.println("MÊs: "+diffMes);
            System.out.println("ANO: "+diffAno);
        }else {
            long diffDias = ChronoUnit.DAYS.between(dt2,dt1);
            long diffMes = ChronoUnit.MONTHS.between(dt2,dt1);
            long diffAno = ChronoUnit.YEARS.between(dt2,dt1);
            System.out.println("DIAS: "+diffDias);
            System.out.println("MÊs: "+diffMes);
            System.out.println("ANO: "+diffAno);
        }
    }
}
