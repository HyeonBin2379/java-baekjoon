package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2553 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
            answer %= 1000000000;
            while (answer % 10 == 0) {
                answer /= 10;
            }
        }
        System.out.println(answer % 10);
    }
}
