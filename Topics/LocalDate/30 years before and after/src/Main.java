import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);
        LocalDate before = date.minusYears(30);
        LocalDate after = date.plusYears(30);
        System.out.println(before);
        System.out.println(after);
        // put your code here
    }
}