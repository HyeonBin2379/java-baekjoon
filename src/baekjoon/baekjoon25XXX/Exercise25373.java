package baekjoon.baekjoon25XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise25373 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n > 28) {
            System.out.println((n-29)/7 + 8);
            return;
        }
        for (int i = 1; i <= 7; i++) {
            if (n <= IntStream.rangeClosed(1, i).sum()) {
                System.out.println(i);
                break;
            }
        }
    }
}
