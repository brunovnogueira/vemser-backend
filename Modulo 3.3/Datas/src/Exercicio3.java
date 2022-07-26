import java.time.LocalDateTime;

public class Exercicio3 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dtAtualizada = now.plusDays(15);
        dtAtualizada = dtAtualizada.plusHours(10);
        System.out.println("DIA DA SEMANA: "+dtAtualizada.getDayOfWeek());
        System.out.println("DIA DO ANO: "+dtAtualizada.getDayOfYear());
    }
}
