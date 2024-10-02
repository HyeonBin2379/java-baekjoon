package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1834 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = 0L;
        for (long i = 1; i < n; i++) {
            answer += n * i + i;
        }
        System.out.println(answer);
    }
}
