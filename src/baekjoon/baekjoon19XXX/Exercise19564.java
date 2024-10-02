package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise19564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = br.readLine().chars().map(ch -> ch-'a').toArray();
        System.out.println(IntStream.rangeClosed(1, num.length-1)
                .filter(idx -> num[idx-1] >= num[idx])
                .count() + 1);
    }
}
