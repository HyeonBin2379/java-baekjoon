package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26170 {

    private static int answer = Integer.MAX_VALUE;
    private static final int[][] map = new int[5][5];
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        dfs(r, c, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int r, int c, int count, int step) {
        if (count == 3) {
            answer = Math.min(step, answer);
            return;
        }

        int temp = map[r][c];   // 백트래킹을 위해 이전 값은 미리 따로 저장
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr > 4 || nc < 0 || nc > 4 || map[nr][nc] == -1) {
                continue;
            }

            // 지나간 칸으로 갱신
            if (map[nr][nc] == 1) {
                count += 1;
            }
            map[r][c] = -1;

            dfs(nr, nc, count, step + 1);   // 백트래킹

            // 지나가기 전으로 수정
            map[r][c] = temp;
            if (map[nr][nc] == 1) {
                count -= 1;
            }
        }
    }
}
