package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17391 {

    private static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dist[i], INF);
        }

        dist[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int boost = map[i][j];
                for (int k = i+1; k <= Math.min(i+boost, n-1); k++) {
                    dist[k][j] = Math.min(dist[k][j], dist[i][j]+1);
                }
                for (int k = j+1; k <= Math.min(j+boost, m-1); k++) {
                    dist[i][k] = Math.min(dist[i][k], dist[i][j]+1);
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}
