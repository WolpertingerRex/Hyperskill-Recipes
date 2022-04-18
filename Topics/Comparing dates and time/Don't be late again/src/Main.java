import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Map<String, LocalTime> stores = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n!=0){
            String[] input = sc.nextLine().split(" ");
            stores.put(input[0], LocalTime.parse(input[1]));
            n--;
        }
        LocalTime myTime = LocalTime.of(20,00);
        stores.entrySet().stream().filter(x-> x.getValue().isAfter(myTime))
                .forEach(x-> System.out.println(x.getKey()));

    }
}