package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dice1 = Integer.parseInt(sc.nextLine());
        int dice2 = Integer.parseInt(sc.nextLine());
        sc.close();

        int count = 0;
        for (int i = 1; i <= dice1; i++) {
            for (int j = dice2; j >= 1; j--) {
                if (i + j == 10) {
                    count++;
                }
            }
        }

        if (count == 1) {
            System.out.printf("There is %d way to get the sum 10.\n", count);
        } else {
            System.out.printf("There are %d ways to get the sum 10.\n", count);
        }
    }
}
