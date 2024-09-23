package bakjoon.bakjoon32XXX;

import java.util.Scanner;

public class Exercise32278 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
            System.out.println("short");
        } else if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
            System.out.println("int");
        } else {
            System.out.println("long long");
        }
    }
}
