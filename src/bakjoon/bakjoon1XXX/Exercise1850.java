package bakjoon.bakjoon1XXX;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Exercise1850 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(LongStream.rangeClosed(1, getGCD(a, b))
                .mapToObj(cnt -> "1")
                .collect(Collectors.joining()));
    }

    private static long getGCD(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
