package algorithm.floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise11780 {

    private static final int INF = (int)1e9;

    private static int[][] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] map = new long[n+1][n+1];

        next = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            map[from][to] = Math.min(cost, map[from][to]);
            next[from][to] = to;
        }
        br.close();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write((map[i][j] == INF ? 0 : map[i][j]) + " ");
            }
            bw.write("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0 || map[i][j] == INF) {
                    bw.write("0\n");
                    continue;
                }
                bw.write(makePath(i, j));
            }
        }
        bw.close();
    }

    private static String makePath(int start, int end) {
        List<String> path = new ArrayList<>();

        while (start != end) {
            path.add(Integer.toString(start));
            start = next[start][end];
        }
        path.add(Integer.toString(end));

        return String.format("%d %s\n", path.size(), String.join(" ", path));
    }
}
