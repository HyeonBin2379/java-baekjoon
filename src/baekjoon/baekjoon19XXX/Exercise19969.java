package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise19969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for (int i = 0; i < 2; i++) {
            answer += Math.min(a[i], b[i]);
            a[i] -= Math.min(a[i], b[i]);
            b[i] -= Math.min(a[i], b[i]);
        }
        answer += Math.min(Math.min(a[2], b[0]+b[1]) + b[2], Math.min(b[2], a[0]+a[1]) + a[2]);
        System.out.println(answer);
    }
}
