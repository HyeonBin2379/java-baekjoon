package bakjoon.bakjoon29XXX;

import java.util.Scanner;

public class Exercise29648 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int s = sc.nextInt();

        for (int i = 1; i*i <= s; i++) {
            if (s % i == 0) {
                int y = s/i;
                if (Math.max(a, b) + i == Math.min(a, b) + y) {
                    System.out.println(Math.max(a, b) + i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
