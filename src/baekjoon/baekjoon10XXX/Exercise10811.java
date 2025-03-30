package baekjoon.baekjoon10XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise10811 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ball = IntStream.rangeClosed(1, n).toArray();

        while (m-- > 0) {
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;

            int[] temp = Arrays.copyOfRange(ball, from, to+1);
            for (int i = 0; i < temp.length; i++) {
                ball[to-i] = temp[i];
            }
        }

        System.out.println(Arrays.stream(ball).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
