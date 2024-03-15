package bakjoon;

import java.util.Scanner;

public class Exercise13699 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] num = new long[n+1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j]*num[i-1-j];
            }
        }
        System.out.println(num[n]);
    }
}
