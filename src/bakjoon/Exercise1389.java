package bakjoon;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Exercise1389 {

    private static final int INF = 987654321;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dist[from][to] = 1;
            dist[to][from] = 1;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int[] score = new int[n+1];
        int min = IntStream.rangeClosed(1, n)
                .map(i -> {
                    score[i] = Arrays.stream(dist[i]).filter(value -> value != INF).sum();
                    return score[i];
                })
                .min()
                .getAsInt();
        System.out.println(IntStream.rangeClosed(1, n).filter(i -> score[i] == min).findFirst().getAsInt());
    }

}
