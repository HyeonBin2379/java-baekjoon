package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = i; j <= 2*i; j++) {
                sum += j;
            }
        }
        System.out.println(sum);
    }
}
