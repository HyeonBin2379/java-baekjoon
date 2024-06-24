package bakjoon.bakjoon21XXX;

import java.util.Scanner;

public class Exercise21633 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        double fee = 25 + num * 0.01;
        System.out.printf("%.2f\n", Math.min(Math.max(fee, 100), 2000));
    }
}
