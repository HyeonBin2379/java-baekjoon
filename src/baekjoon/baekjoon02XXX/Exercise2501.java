package baekjoon.baekjoon02XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (n/i != i) {
                    factors.add(n/i);
                }
            }
        }
        factors.sort(null);

        if (factors.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(factors.get(k - 1));
        }
    }
}
