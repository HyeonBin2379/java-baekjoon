package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1182 {

    private static int n, count;
    private static long total;
    private static long[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        total = Long.parseLong(st.nextToken());

        input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        backtracking(0, 0);
        System.out.println(count);
    }

    private static void backtracking(int step, long sum) {
        if (step == n) {
            return;
        }
        if (sum+input[step] == total) {
            count++;
        }
        backtracking(step+1, sum+input[step]);
        backtracking(step+1, sum);
    }
}
