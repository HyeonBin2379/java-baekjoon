package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise17086 {

    private static final Queue<Integer[]> queue = new LinkedList<>();
    private static final int[] r = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] c = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = new int[n][m];
        for (int i = 0; i < n; i++) {
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                if (input[i][j] == 1) {
                    queue.add(new Integer[] {i, j});
                }
            }
        }
        bfs();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, input[i][j]);
            }
        }
        System.out.println(answer-1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nr = now[0] + r[i];
                int nc = now[1] + c[i];

                if (nr < 0 || nr >= input.length || nc < 0 || nc >= input[0].length || input[nr][nc] == 1) {
                    continue;
                }
                if (input[nr][nc] == 0) {
                    input[nr][nc] = input[now[0]][now[1]] + 1;
                    queue.add(new Integer[] {nr, nc});
                }
            }
        }
    }
}
