package bakjoon.bakjoon6XXX;

import java.util.Scanner;

public class Exercise6815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        int count = 0;
        for (long i = 1; i <= 100; i++) {
            long num = (long) Math.pow(i, 6);
            if (num >= start && num <= end) {
                count++;
            }
        }
        System.out.println(count);
    }
}
