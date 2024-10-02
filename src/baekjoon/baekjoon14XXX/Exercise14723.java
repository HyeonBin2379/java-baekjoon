package baekjoon.baekjoon14XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise14723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = IntStream.iterate(1, i -> i+1)
                .dropWhile(i -> i*(i+1)/2 < n)
                .limit(1)
                .min()
                .getAsInt();
        int b = n - (cnt-1)*cnt/2;
        int a = cnt+1 - b;
        System.out.println(a + " " + b);
    }
}
