package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise10971 {

    private static int n;
    private static long answer = Long.MAX_VALUE;
    private static boolean[] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int start, int now, long cost) {
        if (IntStream.rangeClosed(0, n-1).allMatch(i -> visited[i])) {
            if (graph[now][start] != 0) {
                answer = Math.min(answer, cost+graph[now][0]);
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i] && graph[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost+graph[now][i]);
                visited[i] = false;
            }
        }
    }
}
