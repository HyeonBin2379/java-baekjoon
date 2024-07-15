package bakjoon.bakjoon02XXX;

import java.util.Scanner;

public class Exercise2502 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[d+1];
        int[] b = new int[d+1];
        a[1] = b[2] = 1;
        for (int i = 3; i <= d; i++) {
            a[i] = a[i-1]+a[i-2];
            b[i] = b[i-1]+b[i-2];
        }

        for (int i = 1; i <= k; i++) {
            int temp = k - (a[d]*i);
            if (temp % b[d] == 0) {
                System.out.println(i + "\n" + (temp/b[d]));
                return;
            }
        }
    }
}
