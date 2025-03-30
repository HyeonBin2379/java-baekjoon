package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = getReverse(sc.nextInt());
        int b = getReverse(sc.nextInt());
        System.out.println(Math.max(a, b));
    }

    public static int getReverse(int num) {
        int res = 0;

        for (int i = 2; i >= 0; i--) {
            res += (num % 10) * (int) Math.pow(10, i);
            num /= 10;
        }
        return res;
    }
}
