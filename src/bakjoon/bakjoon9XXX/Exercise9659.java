package bakjoon.bakjoon9XXX;

import java.util.Scanner;

public class Exercise9659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}