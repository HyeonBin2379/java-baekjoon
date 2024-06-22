package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2660 {

    private static final int INF = 987654321;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        setDistance(n);
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int[] score = new int[n+1];
        for (int i = 1; i <= n; i++) {
            final int num = i;
            score[i] = IntStream.rangeClosed(1, n)
                    .filter(index -> dist[num][index] != INF)
                    .map(index -> dist[num][index])
                    .max()
                    .getAsInt();
        }

        int min = IntStream.rangeClosed(1, n).map(index -> score[index]).min().getAsInt();
        int[] candidates = IntStream.rangeClosed(1, n).filter(index -> score[index] == min).toArray();
        System.out.println(min + " " + candidates.length);
        System.out.println(Arrays.stream(candidates).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    private static void setDistance(int n) {
        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
    }
}
