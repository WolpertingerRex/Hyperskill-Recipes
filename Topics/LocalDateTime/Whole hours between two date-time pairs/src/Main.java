import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime date1 = LocalDateTime.parse(sc.nextLine());
        LocalDateTime date2 = LocalDateTime.parse(sc.nextLine());

        long hours = ChronoUnit.HOURS.between(date1, date2);
        System.out.println(hours);
    }
}