package bakjoon;

import java.util.Scanner;

public class Exercise1418 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int now = i;
            int max = 0;
            for (int j = 2; j <= Math.sqrt(i);) {
                if (now % j == 0) {
                    now /= j;
                    max = j;
                } else {
                    j++;
                }
            }
            if (now != 1) {
                max = now;
            }
            if (max <= k) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
