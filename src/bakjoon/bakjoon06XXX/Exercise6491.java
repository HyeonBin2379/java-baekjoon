package bakjoon.bakjoon06XXX;

import java.util.Scanner;

public class Exercise6491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }

            int sum = getSum(num);
            if (num > sum) {
                System.out.println(num + " DEFICIENT");
            } else if (num == sum) {
                System.out.println(num + " PERFECT");
            } else {
                System.out.println(num + " ABUNDANT");
            }
        }
        sc.close();
    }

    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}