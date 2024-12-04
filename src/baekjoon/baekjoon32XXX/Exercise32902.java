package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32902 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int min = n+1;
        int max = k*n+1;
        System.out.println(min + " " + max);
    }
}
