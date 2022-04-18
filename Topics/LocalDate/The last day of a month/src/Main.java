import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        LocalDate date = LocalDate.ofYearDay(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]));

        LocalDate afterDate = date.plusDays(1);

        if(afterDate.getDayOfMonth()==1) System.out.println(true);
        else System.out.println(false);
    }
}