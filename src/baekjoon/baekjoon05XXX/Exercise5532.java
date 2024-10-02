package baekjoon.baekjoon05XXX;

import java.util.Scanner;

public class Exercise5532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int day1 = (a % c == 0) ? a/c : a/c+1;
        int day2 = (b % d == 0) ? b/d : b/d+1;
        System.out.println(l - Math.max(day1, day2));
    }
}
