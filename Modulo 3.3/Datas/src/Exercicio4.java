import java.time.*;

public class Exercicio4 {
    public static void main(String[] args) {
        LocalDateTime dataShow = LocalDateTime.of(2024,9,14,18,30);
        ZoneId zoneId = ZoneId.of("Europe/London");
        LocalDateTime now = LocalDateTime.now(zoneId);

        LocalDate dataShowLocalDate = dataShow.toLocalDate();
        LocalDate nowTolocalDate = now.toLocalDate();
        LocalTime dataShowLocalTime = dataShow.toLocalTime();
        LocalTime nowLocalTime = now.toLocalTime();
        Duration duration = Duration.between(nowLocalTime,dataShowLocalTime);
        Period period = Period.between(nowTolocalDate,dataShowLocalDate);

        long horas = duration.toHours();
        //Transformas as horas em minutos e ver a diferença
        long minutos = duration.toMinutes() - (horas*60);
        //Transformar horas e minutos em segundos, somar e ver a diferença
        long segundos = duration.toSeconds() - ((horas*3600)+(minutos*60));

        System.out.println(period.getYears()+" ANOS");
        System.out.println(period.getMonths()+" MESES") ;
        System.out.println(period.getDays()+" DIAS");
        System.out.println(horas+" HORAS");
        System.out.println(minutos+" MINUTOS");
        System.out.println(segundos+" SEGUNDOS");
    }
}
