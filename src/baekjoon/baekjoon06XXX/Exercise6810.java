package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] isbn = {9, 7, 8, 0, 9, 2, 1, 4, 1, 8, 0, 0, 0};
        isbn[10] = sc.nextInt();
        isbn[11] = sc.nextInt();
        isbn[12] = sc.nextInt();
        sc.close();

        int sum = 0;
        for (int i = 0; i < isbn.length; i++) {
            sum += (i % 2 == 0) ? isbn[i] : isbn[i]*3;
        }
        System.out.printf("The 1-3-sum is %d\n", sum);
    }
}
