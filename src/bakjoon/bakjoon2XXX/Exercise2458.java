package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise2458 {

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }

        int answer = (int) IntStream.rangeClosed(1, n)
                .mapToLong(i -> IntStream.rangeClosed(1, n).filter(j -> graph[i][j] != INF || graph[j][i] != INF).count())
                .filter(cnt -> cnt == n-1)
                .count();
        System.out.println(answer);
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
    }
}
