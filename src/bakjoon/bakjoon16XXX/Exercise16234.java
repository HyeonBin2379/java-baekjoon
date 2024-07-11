package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise16234 {

    private static int n, l, r;
    private static int[][] nation;
    private static boolean[][] visited;
    private static final Queue<Integer[]> queue = new LinkedList<>();
    private static final int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        nation = new int[n][n];
        for (int i = 0; i < n; i++) {
            nation[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;
        while (true) {
            int moveCount = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        moveCount += migrate(i, j);
                    }
                }
            }
            if (moveCount == 0) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static int migrate(int row, int col) {
        List<Integer[]> union = new ArrayList<>();
        union.add(new Integer[]{row, col});
        queue.offer(new Integer[]{row, col});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : dir) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];
                visited[now[0]][now[1]] = true;

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }
                int diff = Math.abs(nation[now[0]][now[1]] - nation[nr][nc]);
                if (diff >= l && diff <= r) {
                    visited[nr][nc] = true;
                    queue.offer(new Integer[]{nr, nc});
                    union.add(new Integer[]{nr, nc});
                }
            }
        }
        if (union.size() > 1) {
            int result = union.stream().mapToInt(pos -> nation[pos[0]][pos[1]]).sum() / union.size();
            union.forEach(pos -> nation[pos[0]][pos[1]] = result);
        }
        return (union.size() <= 1) ? 0 : 1;
    }
}
