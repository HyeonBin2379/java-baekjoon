package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise14502 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int row, col, answer;
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        search(0);
        System.out.println(answer);
    }

    private static void search(int depth) {
        if (depth == 3) {
            spread();
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    search(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spread() {
        Queue<Integer[]> queue = new ArrayDeque<>();
        int virus = 0, wall = 0;
        int[][] temp = new int[row][col];
        IntStream.range(0, row).forEach(idx -> temp[idx] = map[idx].clone());
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (temp[i][j] == 2) {
                    virus++;
                    queue.offer(new Integer[]{i, j});
                } else if (temp[i][j] == 1) {
                    wall++;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                int nr = now[0]+move[0];
                int nc = now[1]+move[1];

                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }
                if (temp[nr][nc] == 0) {
                    temp[nr][nc] = 2;
                    virus++;
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
        answer = Math.max(answer, row*col-wall-virus);
    }
}
