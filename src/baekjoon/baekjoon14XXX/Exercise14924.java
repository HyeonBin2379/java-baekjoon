package baekjoon.baekjoon14XXX;

import java.util.Scanner;

public class Exercise14924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        System.out.println(t*(d/(s*2)));
    }
}
