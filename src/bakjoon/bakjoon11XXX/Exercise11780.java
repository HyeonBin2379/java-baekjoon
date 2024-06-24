package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise11780 {

    private static final int INF = 987654321;
    private static int[][] graph;
    private static int[][] stopover;
    private static final Deque<String> route = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        setGraph(n);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = Math.min(cost, graph[from][to]);
        }

        stopover = new int[n+1][n+1];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        stopover[i][j] = k;
                    }
                }
            }
        }
        getResult(n);
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
    }

    private static void getRoute(int start, int end) {
        if (stopover[start][end] == 0) {
            route.addLast(Integer.toString(start));
            route.addLast(Integer.toString(end));
            return;
        }
        getRoute(start, stopover[start][end]);
        route.pollLast();
        getRoute(stopover[start][end], end);
    }

    private static void getResult(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0).append("\n");
                    continue;
                }
                route.clear();
                getRoute(i, j);
                sb.append(route.size()).append(" ")
                        .append(String.join(" ", route))
                        .append("\n");
            }
        }
        System.out.print(sb);
    }
}
