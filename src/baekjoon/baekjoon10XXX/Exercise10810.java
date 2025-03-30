package baekjoon.baekjoon10XXX;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise10810 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ball = new int[n+1];
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int k = sc.nextInt();

            for (int i = from; i <= to; i++) {
                ball[i] = k;
            }
        }

        System.out.println(IntStream.rangeClosed(1, n)
                .mapToObj(value -> Integer.toString(ball[value]))
                .collect(Collectors.joining(" ")));
    }
}
