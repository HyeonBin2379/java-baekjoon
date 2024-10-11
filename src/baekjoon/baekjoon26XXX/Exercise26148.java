package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26148 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int day = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(30);
        } else {
            System.out.println(29);
        }
    }
}
