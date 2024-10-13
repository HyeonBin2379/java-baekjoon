package baekjoon.baekjoon27XXX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise27258 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (getGCD(i, j) == 1) {
                    double fraction = (double) i/j;
                    if (fraction > 1.0/p && fraction < 1.0/q) {
                        answer.add(i + "/" + j);
                    }
                }
            }
        }
        answer.sort((o1, o2) -> {
            int[] token1 = Arrays.stream(o1.split("/")).mapToInt(Integer::parseInt).toArray();
            int[] token2 = Arrays.stream(o2.split("/")).mapToInt(Integer::parseInt).toArray();
            return Double.compare((double)token1[0]/token1[1], (double)token2[0]/token2[1]);
        });
        answer.forEach(System.out::println);
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
