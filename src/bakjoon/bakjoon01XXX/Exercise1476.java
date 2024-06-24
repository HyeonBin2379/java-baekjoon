package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1476 {

    private static int earth, sun, moon;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        earth = sc.nextInt();
        sun = sc.nextInt();
        moon = sc.nextInt();

        int year = 1;
        while (isNotMatched(year)) {
            year++;
        }
        System.out.println(year);
    }

    public static boolean isNotMatched(int year) {
        return (year - earth) % 15 != 0 || (year - sun) % 28 != 0 || (year - moon) % 19 != 0;
    }
}
