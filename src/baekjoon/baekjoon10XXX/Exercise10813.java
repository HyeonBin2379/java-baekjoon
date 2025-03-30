package baekjoon.baekjoon10XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise10813 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ball = IntStream.rangeClosed(1, n).toArray();
        while (m-- > 0) {
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;

            int temp = ball[from];
            ball[from] = ball[to];
            ball[to] = temp;
        }

        System.out.println(Arrays.stream(ball).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
