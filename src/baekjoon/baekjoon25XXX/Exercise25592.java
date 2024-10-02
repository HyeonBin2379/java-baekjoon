package baekjoon.baekjoon25XXX;

import java.util.Scanner;

public class Exercise25592 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prefixSum = new int[451];

        for (int i = 1; i <= 450; i++) {
            prefixSum[i] = prefixSum[i-1] + i;
            if (n < prefixSum[i]) {
                System.out.println(i % 2 == 1 ? prefixSum[i]-n : 0);
                return;
            }
        }
    }
}
