import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        LocalDateTime date = LocalDateTime.parse(input[0]);
        date = date.plusDays(Integer.parseInt(input[1]));
        date = date.minusHours(Integer.parseInt(input[2]));
        System.out.println(date);
    }
}