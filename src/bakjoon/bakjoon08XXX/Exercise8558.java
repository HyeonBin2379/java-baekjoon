package bakjoon.bakjoon08XXX;

import java.util.Scanner;

public class Exercise8558 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println(1);
        } else if (num < 5) {
            System.out.println(factorial(num));
        } else {
            System.out.println(0);
        }
    }

    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
            result %= 10;
        }
        return result;
    }
}
