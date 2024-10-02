package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise6462 {

    private static final int INF = 1000000000;
    private static final int[][] graph = new int[21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int testNum = 0;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            IntStream.rangeClosed(1, 20).forEach(i -> {
                Arrays.fill(graph[i], INF);
                graph[i][i] = 0;
            });

            for (int i = 1; i <= 19; i++) {
                StringTokenizer st = (i == 1) ? new StringTokenizer(input) : new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                for (int j = 0; j < n; j++) {
                    int to = Integer.parseInt(st.nextToken());
                    graph[i][to] = 1;
                    graph[to][i] = 1;
                }
            }

            conquer();

            int q = Integer.parseInt(br.readLine());
            sb.append(String.format("Test Set #%d\n", ++testNum));
            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                sb.append(String.format("%2d to %2d: %d\n", from, to, graph[from][to]));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void conquer() {
        for (int k = 1; k <= 20; k++) {
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }
    }
}
