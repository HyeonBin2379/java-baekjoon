package bakjoon;

import java.util.Scanner;

public class Exercise8674 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long row = sc.nextLong();
        long col = sc.nextLong();
        if (row % 2 == 0 || col % 2 == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(Math.min(row, col));
    }
}
