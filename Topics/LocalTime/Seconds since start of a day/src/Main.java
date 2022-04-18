import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int sec = Integer.parseInt(sc.nextLine());
        LocalTime time = LocalTime.ofSecondOfDay(sec);
        System.out.println(time);
    }
}