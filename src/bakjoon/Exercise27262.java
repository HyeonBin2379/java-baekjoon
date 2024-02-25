package bakjoon;

import java.util.Scanner;

public class Exercise27262 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int stair = a*(n-1);
        int elevator = (k > 1) ? (n+k-2)*b : (n-1)*b;
        System.out.println(elevator + " " + stair);
    }
}
