package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6219 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        int answer = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i) && containNum(i, d)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean containNum(int num, int d) {
        while (num > 0) {
            if (num % 10 == d) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
