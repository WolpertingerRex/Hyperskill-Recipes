import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]input = sc.nextLine().split(":");
        String[]toSubstract =  sc.nextLine().split(" ");
        LocalTime time = LocalTime.of(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        time = time.minusHours(Integer.parseInt(toSubstract[0]));
        time = time.minusMinutes(Integer.parseInt(toSubstract[1]));
        System.out.println(time);
    }
}