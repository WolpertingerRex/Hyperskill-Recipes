import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<LocalDateTime> dates = new ArrayList<>();
        while (n != 0){
            dates.add(LocalDateTime.parse(sc.nextLine()));
            n--;
        }

      LocalDateTime min = dates.stream().max(Comparator.naturalOrder()).orElse(null);
        System.out.println(min);

    }
}