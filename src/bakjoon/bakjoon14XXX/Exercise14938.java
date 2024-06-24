package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14938 {

    private static final int INF = 987654321;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] local = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            local[i] = Integer.parseInt(st.nextToken());
        }

        setGraph(n);
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[from][to] = dist;
            map[to][from] = dist;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }

        int[] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= m) {
                    answer[i] += local[j];
                }
            }
        }
        System.out.println(Arrays.stream(answer).max().getAsInt());
    }

    private static void setGraph(int n) {
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
    }
}
