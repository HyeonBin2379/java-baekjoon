package bakjoon;

import java.util.Scanner;

public class Exercise27239 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int row = (int) Math.ceil((double) num / 8);
        char col = (char) ('a' + ((num % 8 == 0) ? 7 : num % 8 - 1));
        System.out.println(col + Integer.toString(row));
    }
}
