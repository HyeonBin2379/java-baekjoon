package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2440 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            System.out.println("*".repeat(i));
        }
    }
}
