import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println(date.getDayOfYear() + " " + date.getDayOfMonth());
        // put your code here
    }
}