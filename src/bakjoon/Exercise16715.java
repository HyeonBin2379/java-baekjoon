package bakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise16715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> result = new TreeMap<>();
        for (int i = 2; i <= n; i++) {
            result.put(i, getSum(n, i));
        }
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(result.entrySet());
        sorted.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getValue()-o1.getValue();
            } else {
                return o1.getKey()-o2.getKey();
            }
        });
        System.out.println(sorted.get(0).getValue() + " " + sorted.get(0).getKey());
    }

    private static int getSum(int num, int base) {
        int sum = 0;
        while (num > 0) {
            sum += num % base;
            num /= base;
        }
        return sum;
    }
}
