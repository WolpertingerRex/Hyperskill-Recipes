import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime range1 = LocalDateTime.parse(sc.nextLine());
        LocalDateTime range2 = LocalDateTime.parse(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        List<LocalDateTime> dates = new ArrayList<>();
        while(n != 0){
            dates.add(LocalDateTime.parse(sc.nextLine()));
            n--;
        }

        LocalDateTime earlier = range1.isBefore(range2) ? range1 : range2;
        LocalDateTime later = range1.isAfter(range2) ? range1 : range2;
        long count = dates.stream()
                .filter(d-> (d.isAfter(earlier) || d.isEqual(earlier)) && d.isBefore(later))
                                .count();
        System.out.println(count);
    }
}