package bakjoon.bakjoon28XXX;

import java.util.Scanner;

public class Exercise28352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long answer = 6;
        for (long i = 11; i <= num; i++) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
