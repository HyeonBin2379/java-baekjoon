package algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1956 {

    private static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        long[][] map = new long[v+1][v+1];
        for (int i = 0; i <= v; i++) {
            // 정점 자신으로 오는 사이클의 길이의 최솟값을 구해야 하므로, map[i][i]의 초기값을 INF로 설정
            Arrays.fill(map[i], INF);
        }
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            map[from][to] = cost;
        }

        long min = INF;
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
            min = Math.min(map[k][k], min);
        }
        System.out.println(min == INF ? -1 : min);
    }
}
