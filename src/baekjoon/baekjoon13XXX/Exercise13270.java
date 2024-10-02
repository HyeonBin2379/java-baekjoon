package baekjoon.baekjoon13XXX;

import java.util.Scanner;

public class Exercise13270 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dpMin = new int[n+1];
        int[] dpMax= new int[n+1];
        int a = 1, b = 2;

        for (int i = 1; i <= n; i++) {
            dpMin[i] = 1000000000;
        }
        while (b <= n) {
            for (int j = b; j <= n; j++) {
                dpMin[j] = Math.min(dpMin[j], dpMin[j-b] + a);
                dpMax[j] = Math.max(dpMax[j], dpMax[j-b] + a);
            }
            b += a;
            a = b-a;
        }
        System.out.println(dpMin[n] + " " + dpMax[n]);
    }
}
