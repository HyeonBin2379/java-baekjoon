package bakjoon.bakjoon06XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise6030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] a_div = getDivisor(a);
        int[] b_div = getDivisor(b);
        for (int k : a_div) {
            for (int i : b_div) {
                sb.append(String.format("%d %d\n", k, i));
            }
        }
        System.out.print(sb);
    }

    public static int[] getDivisor(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                result.add(i);
                if (i != num/i) {
                    result.add(num / i);
                }
            }
        }
        result.sort(null);
        return result.stream().mapToInt(value -> value).toArray();
    }
}
