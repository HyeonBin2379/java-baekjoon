package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int minDiff = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = cards[i]+cards[j]+cards[k];
                    int diff = m-sum;
                    if (diff >= 0 && diff <= minDiff) {
                        minDiff = diff;
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
