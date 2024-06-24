package bakjoon.bakjoon18XXX;

import java.util.Scanner;

public class Exercise18330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println((n <= k+60) ? 1500*n : 3000*n-1500*k-90000);
    }
}
