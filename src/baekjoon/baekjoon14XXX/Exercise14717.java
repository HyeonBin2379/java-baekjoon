package baekjoon.baekjoon14XXX;

import java.util.Scanner;

public class Exercise14717 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a == b) {
            System.out.printf("%.3f\n", (double)(143+a)/153);
            return;
        }
        int win = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = i+1; j <= 10; j++) {
                if ((a+b)%10 > (i+j)%10) {
                    if (i == a && j == b) {
                        continue;
                    }
                    if (i == a || j == a || i == b || j == b) {
                        win += 2;
                    } else {
                        win += 4;
                    }
                }
            }
        }
        System.out.printf("%.3f\n", (double)win/153);
    }
}
