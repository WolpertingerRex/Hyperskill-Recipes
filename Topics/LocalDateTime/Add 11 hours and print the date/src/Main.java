
import java.time.LocalDateTime;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(sc.nextLine());
        date = date.plusHours(11);
        System.out.println(date.toLocalDate());
    }
}