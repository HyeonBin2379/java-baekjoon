package baekjoon.baekjoon19XXX;

import java.util.Scanner;

public class Exercise19602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        sc.close();

        int sum = s + 2*m + 3*l;
        System.out.println((sum >= 10) ? "happy" : "sad");
    }
}
