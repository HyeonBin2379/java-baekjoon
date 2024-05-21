package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise16956 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] field = new char[n][m];

        Queue<Integer[]> sheep = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            field[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 'S') {
                    sheep.add(new Integer[] {i, j});
                }
            }
        }

        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        while (!sheep.isEmpty()) {
            Integer[] now = sheep.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + r[i];
                int nc = now[1] + c[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (field[nr][nc] == 'W') {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
        for (int i = 0; i < n; i++) {
            System.out.println(new String(field[i]).replace(".", "D"));
        }
    }
}
