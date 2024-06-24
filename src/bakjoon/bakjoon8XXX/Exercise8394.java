package bakjoon.bakjoon8XXX;

import java.util.Scanner;

public class Exercise8394 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        for (int i = 0; i <= n; i++) {
            num[i] = (i < 2) ? 1 : (num[i-1] % 10) + (num[i-2] % 10);
        }
        System.out.println(num[n] % 10);
    }
}
