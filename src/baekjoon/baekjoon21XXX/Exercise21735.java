package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise21735 {

    private static int n, m, answer;
    private static int[] snowball;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        snowball = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        roll(0, 0, 1);
        System.out.println(answer);
    }

    private static void roll(int move, int time, int total) {
        if (move >= n || time == m) {
            answer = Math.max(total, answer);
            return;
        }
        roll(move+1, time+1, total + snowball[move]);
        if (move+1 < n) {
            roll(move+2, time+1, total/2 + snowball[move+1]);
        }
    }
}
