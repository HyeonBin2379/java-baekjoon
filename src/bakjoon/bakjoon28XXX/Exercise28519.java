package bakjoon.bakjoon28XXX;

import java.util.Scanner;

public class Exercise28519 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println((Math.abs(n-m) > 1) ? 2*Math.min(n, m) + 1 : n+m);
    }
}
