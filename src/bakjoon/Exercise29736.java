package bakjoon;

import java.util.Scanner;

public class Exercise29736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (Math.abs(i-k) <= x) {
                count++;
            }
        }
        System.out.println((count > 0) ? count : "IMPOSSIBLE");
        sc.close();
    }
}
