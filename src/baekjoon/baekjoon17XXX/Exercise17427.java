package baekjoon.baekjoon17XXX;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Exercise17427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(LongStream.rangeClosed(1, n).map(i -> i*(n/i)).sum());
    }
}
