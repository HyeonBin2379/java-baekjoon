package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise21940 {

    private static final int INF = 1000000000;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setGraph(n);
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a][b] = cost;
        }

        floyd(n);

        int k = Integer.parseInt(br.readLine());
        int[] residence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                int cityNum = residence[j];
                answer[i] = Math.max(answer[i], graph[i][cityNum]+graph[cityNum][i]);
            }
        }
        int min = IntStream.rangeClosed(1, n).map(i -> answer[i]).reduce(INF, Integer::min);
        System.out.println(IntStream.rangeClosed(1, n)
                .filter(index -> answer[index] == min)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" ")));
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        IntStream.rangeClosed(1, n).forEach(i -> {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        });
    }

    private static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }
    }
}
