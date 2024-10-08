package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18429 {

    private static int n, k, answer;
    private static int[] weight;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];
        backtracking(0, 500);
        System.out.println(answer);
    }

    private static void backtracking(int count, int total) {
        if (count == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && total+weight[i]-k >= 500) {
                visited[i] = true;
                backtracking(count + 1, total + weight[i] - k);
                visited[i] = false;
            }
        }
    }
}
