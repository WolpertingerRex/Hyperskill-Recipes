import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());
        int day1 = Integer.parseInt(sc.nextLine());
        int day2 = Integer.parseInt(sc.nextLine());
        int day3 = Integer.parseInt(sc.nextLine());

        System.out.println(LocalDate.ofYearDay(year, day1));
        System.out.println(LocalDate.ofYearDay(year, day2));
        System.out.println(LocalDate.ofYearDay(year, day3));
    }
}