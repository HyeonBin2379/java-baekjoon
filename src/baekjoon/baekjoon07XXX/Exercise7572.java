package baekjoon.baekjoon07XXX;

import java.util.Scanner;

public class Exercise7572 {

    private static final String gan = "6789012345";
    private static final String zi = "IJKLABCDEFGH";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.printf("%c%c", zi.charAt(year % 12), gan.charAt(year % 10));
    }
}
