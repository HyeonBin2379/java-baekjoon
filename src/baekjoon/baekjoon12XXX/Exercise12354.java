package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise12354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = (int) IntStream.rangeClosed(0, n-2).filter(idx -> height[idx] >= height[idx+1]).count();
            bw.write(String.format("Case #%d: %d\n", i, count));
        }
        br.close();
        bw.close();
    }
}
