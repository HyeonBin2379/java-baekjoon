package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14913 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        System.out.println((k-a) % d != 0 ? "X" : (k-a)/d < 0 ? "X" : (k-a)/d+1);
    }
}
