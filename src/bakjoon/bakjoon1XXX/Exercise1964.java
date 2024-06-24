package bakjoon.bakjoon1XXX;

import java.util.Scanner;

public class Exercise1964 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = (3L * n + 2)*(n+1)/2;
        System.out.println(sum % 45678);
    }
}
