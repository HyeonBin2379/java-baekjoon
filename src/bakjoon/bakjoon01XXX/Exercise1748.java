package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = Integer.toString(n).length();

        if (len == 1) {
            System.out.println(n);
            return;
        }
        int answer = 0;
        for (int i = 1; i <= len; i++) {
            if (i < len) {
                answer += 9 * i * Math.pow(10, i-1);
            } else {
                answer += i * (n - Math.pow(10, len-1) + 1);
            }
        }
        System.out.println(answer);
    }
}
