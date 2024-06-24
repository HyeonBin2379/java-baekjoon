package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1600 {

    private static int k, w, h;
    private static int[][] map;
    private static boolean[][][] visited;

    private static final int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        for (int i = 0; i < h; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(bfs());
    }

    private static class MoveInfo {
        int h, w;
        int moveCnt, abilityCnt;

        public MoveInfo(int h, int w, int moveCnt, int abilityCnt) {
            this.h = h;
            this.w = w;
            this.moveCnt = moveCnt;
            this.abilityCnt = abilityCnt;
        }
    }
    private static int bfs() {
        Queue<MoveInfo> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new MoveInfo(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            MoveInfo now = queue.poll();

            if (now.w == w-1 && now.h == h-1) {
                return now.moveCnt;
            }

            if (now.abilityCnt < k) {
                for (int[] ints : horse) {
                    int nh = now.h + ints[0];
                    int nw = now.w + ints[1];

                    if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
                        continue;
                    }
                    if (map[nh][nw] == 0 && !visited[nh][nw][now.abilityCnt + 1]) {
                        visited[nh][nw][now.abilityCnt + 1] = true;
                        queue.add(new MoveInfo(nh, nw, now.moveCnt + 1, now.abilityCnt + 1));
                    }
                }
            }

            for (int[] ints : move) {
                int nh = now.h + ints[0];
                int nw = now.w + ints[1];

                if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
                    continue;
                }
                if (map[nh][nw] == 0 && !visited[nh][nw][now.abilityCnt]) {
                    visited[nh][nw][now.abilityCnt] = true;
                    queue.add(new MoveInfo(nh, nw, now.moveCnt + 1, now.abilityCnt));
                }
            }
        }
        return -1;
    }
}