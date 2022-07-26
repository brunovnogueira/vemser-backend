import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        exercicio1(sc);
        exercicio2(sc);
        exercicio3();
        exercicio4();
    }

    private static void exercicio1(Scanner sc) {
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

    private static void exercicio2(Scanner sc) {
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

    private static void exercicio3() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dtAtualizada = now.plusDays(15);
        dtAtualizada = dtAtualizada.plusHours(10);
        System.out.println("DIA DA SEMANA: "+dtAtualizada.getDayOfWeek());
        System.out.println("DIA DO ANO: "+dtAtualizada.getDayOfYear());
    }

    private static void exercicio4() {
        LocalDateTime dataShow = LocalDateTime.of(2024,9,14,18,30);
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDateTime now = LocalDateTime.now(zoneId);

        LocalDate dataShowLocalDate = dataShow.toLocalDate();
        LocalDate nowTolocalDate = now.toLocalDate();
        LocalTime dataShowLocalTime = dataShow.toLocalTime();
        LocalTime nowLocalTime = now.toLocalTime();

        Period period = Period.between(nowTolocalDate,dataShowLocalDate);

        long horas = ChronoUnit.HOURS.between(nowLocalTime,dataShowLocalTime);
        //Transformas as horas em minutos e ver a diferença
        long minutos = ChronoUnit.MINUTES.between(nowLocalTime,dataShowLocalTime) - (horas*60);
        //Transformar horas e minutos em segundos, somar e ver a diferença
        long segundos = ChronoUnit.SECONDS.between(nowLocalTime,dataShowLocalTime) - ((horas*3600)+(minutos*60));

        System.out.println(period.getYears()+" ANOS");
        System.out.println(period.getMonths()+" MESES") ;
        System.out.println(period.getDays()+" DIAS");
        System.out.println(horas+" HORAS");
        System.out.println(minutos+" MINUTOS");
        System.out.println(segundos+" SEGUNDOS");
    }
}
