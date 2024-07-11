package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise10819 {

    private static int n, answer;
    private static int[] num, selected;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];
        selected = new int[n];
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int step) {
        if (step == n) {
            int result = IntStream.rangeClosed(0, n-2).map(i -> Math.abs(selected[i]-selected[i+1])).sum();
            answer = Math.max(result, answer);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[step] = num[i];
                backtracking(step+1);
                visited[i] = false;
            }
        }
    }
}
