package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1956 {

    private static final int INF = 987654321;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        setGraph(v);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from][to] = dist;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
        int min = IntStream.rangeClosed(1, v).map(i -> graph[i][i]).min().getAsInt();
        System.out.println(min == INF ? -1 : min);
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
    }
}
