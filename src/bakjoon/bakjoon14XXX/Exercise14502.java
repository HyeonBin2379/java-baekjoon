package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14502 {

    private static int row, col, answer;
    private static int[][] map;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        makeWall(0);
        System.out.println(answer);
    }

    private static void bfs() {
        int[][] temp = copyArray(map);
        Queue<Integer[]> virus = initQueue(temp);

        while (!virus.isEmpty()) {
            Integer[] now = virus.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now[0];
                int nc = dc[i] + now[1];

                if (nr < 0 || nr >= row || nc < 0 || nc >= col || temp[nr][nc] != 0) {
                    continue;
                }
                temp[nr][nc] = 2;
                virus.add(new Integer[] {nr, nc});
            }
        }

        int count = (int) Arrays.stream(temp)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == 0)
                .count();
        answer = Math.max(count, answer);
    }

    private static int[][] copyArray(int[][] map) {
        int[][] copied = new int[row][col];
        for (int i = 0; i < row; i++) {
            copied[i] = map[i].clone();
        }
        return copied;
    }
    private static Queue<Integer[]> initQueue(int[][] temp) {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (temp[i][j] == 2) {
                    queue.add(new Integer[] {i, j});
                }
            }
        }
        return queue;
    }

    private static void makeWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
