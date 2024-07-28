package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise22352 {

    private static int n, m;
    private static int[][] before, after;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        before = new int[n][m];
        for (int i = 0; i < n; i++) {
            before[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        after = new int[n][m];
        for (int i = 0; i < n; i++) {
            after[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        inject(1);

        // 변경된 주입 전 데이터와 주입 결과를 비교하여 두 배열이 서로 동일한지 확인
        // 두 배열이 동일하면 항체를 주입한 것
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static void inject(int count) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 백신 주입은 1회만 수행
                if (before[i][j] != after[i][j] && --count == 0) {
                    bfs(i, j, before[i][j], after[i][j]);
                    return;
                }
            }
        }
    }

    private static void bfs(int r, int c, int b, int a) {
        Queue<Integer[]> queue = new LinkedList<>();
        before[r][c] = after[r][c];
        queue.offer(new Integer[]{r, c});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                // 데이터가 서로 다른 칸이면 주입 전의 데이터를 주입 후의 데이터로 갱신
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (before[nr][nc] == b) {
                        before[nr][nc] = a;
                        queue.offer(new Integer[]{nr, nc});
                    }
                }
            }
        }
    }
}
