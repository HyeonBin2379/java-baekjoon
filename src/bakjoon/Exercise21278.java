package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise21278 {

    private static final int INF = 987654321;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setGraph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }

        int minSum = INF;
        String result = "";
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= n; j++) {
                int a = i, b = j;
                int sum = IntStream.rangeClosed(1, n).map(k -> 2*Math.min(graph[k][a], graph[k][b])).sum();
                if (sum < minSum) {
                    minSum = sum;
                    result = String.format("%d %d %d\n", i, j, minSum);
                }
            }
        }
        System.out.print(result);
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
    }
}
