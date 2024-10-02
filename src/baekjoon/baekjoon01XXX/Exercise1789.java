package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long sum = 0;
        int count = 0;
        for (long i = 1; sum + i <= s; i++) {
            sum += i;
            count++;
        }
        System.out.println(count);
    }
}
