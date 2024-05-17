package bakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise28237 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> divisor1 = getDivisor(n);
        List<Integer> divisor2 = getDivisor(n+2);

        for (int a : divisor1) {
            for (int b : divisor2) {
                int c = n/a;
                int d = -((n+2)/b);
                if (b*c + a*d == n+1) {
                    System.out.printf("%d %d %d %d\n", a, b, c, d);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static List<Integer> getDivisor(int num) {
        List<Integer> divisor = new ArrayList<>();
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                divisor.add(-i);
                divisor.add(i);
            }
        }
        Collections.sort(divisor);
        return divisor;
    }
}
