package baekjoon.baekjoon28XXX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise28431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        for (Integer num : count.keySet()) {
            if (count.get(num) % 2 == 1) {
                System.out.println(num);
                break;
            }
        }
        sc.close();
    }
}
