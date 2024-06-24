package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ranking {

    private static final int INF = 987654321;
    private static int[][] graph;

    public int solution(int n, int[][] results) {
        setGraph(n);
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
                }
            }
        }

        return (int) IntStream.rangeClosed(1, n)
                .mapToLong(i -> IntStream.rangeClosed(1, n).filter(j -> graph[i][j] != INF || graph[j][i] != INF).count())
                .filter(cnt -> cnt == n-1)
                .count();
    }

    private static void setGraph(int n) {
        graph = new int[n+1][n+1];
        IntStream.rangeClosed(1, n).forEach(i -> {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        });
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(new Ranking().solution(n, result));
    }
}
