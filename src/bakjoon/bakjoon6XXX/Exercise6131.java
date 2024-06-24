package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        for (int b = 1; b <= 500; b++) {
            for (int a = b; a <= 500; a++) {
                if (a*a - b*b == n) {
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
