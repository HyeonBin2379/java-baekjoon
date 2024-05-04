package bakjoon;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise11680 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> sum = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum.put(i+j, sum.getOrDefault(i+j, 0)+1);
            }
        }
        int max = sum.values().stream().max(Comparator.comparingInt(o -> o)).get();
        sum.keySet().stream()
                .filter(val -> sum.get(val) == max)
                .forEach(System.out::println);
    }
}
