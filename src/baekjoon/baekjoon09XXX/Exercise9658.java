package baekjoon.baekjoon09XXX;

import java.util.Scanner;

public class Exercise9658 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num % 7 == 1 || num % 7 == 3 ? "CY" : "SK");
    }
}