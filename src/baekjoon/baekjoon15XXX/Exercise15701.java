package baekjoon.baekjoon15XXX;

import java.util.Scanner;

public class Exercise15701 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n/i) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
