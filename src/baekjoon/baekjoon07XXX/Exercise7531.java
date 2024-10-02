package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7531 {

    private static int p, q;
    private static boolean[][] visited;
    private static StringBuilder path;
    private static String result;
    private static final int[][] move = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, -2}, {-1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            visited = new boolean[p][q];
            path = new StringBuilder();
            result = "";

            sb.append("Scenario #").append(i).append(":\n");
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < q; k++) {
                    visited[j][k] = true;
                    path.append((char) ('A' + k)).append(j + 1);
                    dfs(j, k, 1);
                    path.setLength(path.length()-2);
                    visited[j][k] = false;
                }
            }

            if (result.isEmpty()) {
                sb.append("impossible\n");
            } else {
                sb.append(result).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int r, int c, int count) {
        if (count == p*q) {
            String newPath = path.toString();
            result = newPath.compareTo(result) < 0 || result.isEmpty() ? newPath : result;
            return;
        }

        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr >= 0 && nr < p && nc >= 0 && nc < q && !visited[nr][nc] && result.isEmpty()) {
                visited[nr][nc] = true;
                path.append((char) ('A' + nc)).append(nr + 1);
                dfs(nr, nc,count + 1);
                path.setLength(path.length() - 2);
                visited[nr][nc] = false;
            }
        }
    }
}
