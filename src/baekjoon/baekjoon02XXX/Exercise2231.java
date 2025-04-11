package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 1000000; i++) {
            int sum = getSum(i);
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    private static int getSum(int num) {
        int result = num;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
