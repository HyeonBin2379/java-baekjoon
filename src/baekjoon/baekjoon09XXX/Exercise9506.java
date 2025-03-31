package baekjoon.baekjoon09XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise9506 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num < 0) {
                break;
            }
            getResult(num);
        }
    }

    private static void getResult(int num) {
        int total = 0;

        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i*i < num; i++) {
            if (num % i == 0) {
                factors.add(i);
                total += i;
                if (num/i != i && i > 1) {
                    factors.add(num/i);
                    total += num/i;
                }
            }
        }
        factors.sort(null);

        if (total == num) {
            System.out.printf("%d = ", num);
            System.out.println(factors.stream()
                    .map(value -> Integer.toString(value))
                    .collect(Collectors.joining(" + ")));
        } else {
            System.out.printf("%d is NOT perfect.\n", num);
        }
    }
}
