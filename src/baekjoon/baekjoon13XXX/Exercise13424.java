package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise13424 {

    private static int n;
    private static int[][] graph;
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());
            setGraph();
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph[from][to] = dist;
                graph[to][from] = dist;
            }

            floyd();

            int k = Integer.parseInt(br.readLine());
            int[] friend = Arrays.stream(br.readLine().split(" ", k)).mapToInt(Integer::parseInt).toArray();
            int minSum = INF;
            int answer = -1;
            for (int i = 1; i <= n; i++) {
                int index = i;
                int sum = Arrays.stream(friend).map(friendNum -> graph[friendNum][index]).sum();
                if (minSum > sum) {
                    minSum = sum;
                    answer = i;
                }
            }
            System.out.println(answer);
        }
    }

    private static void setGraph() {
        graph = new int[n+1][n+1];
        IntStream.rangeClosed(1, n).forEach(i -> {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        });
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }
    }
}
