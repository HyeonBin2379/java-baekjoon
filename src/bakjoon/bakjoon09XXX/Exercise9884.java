package bakjoon.bakjoon09XXX;

import java.util.Scanner;

public class Exercise9884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(getGCD(a, b));
    }

    private static int getGCD(int a, int b) {
        return (b > 0) ? getGCD(b, a % b) : a;
    }
}
