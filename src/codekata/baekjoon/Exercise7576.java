package codekata.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise7576 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Queue<Integer[]> queue = new LinkedList<>();

    private static int[][] boxes, dayCnts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boxes = new int[m][n];
        dayCnts = new int[m][n];

        int total = n*m;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dayCnts[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
                switch (boxes[i][j]) {
                    case -1:
                        total--;
                        break;
                    case 1:
                        queue.add(new Integer[]{i, j});
                        dayCnts[i][j] = 0;
                        total--;
                        break;
                }
            }
        }
        int answer = bfs(m, n, total);
        System.out.println(answer);
    }

    private static int bfs(int m, int n, int total) {
        int answer = 0;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                int nextRow = now[0]+move[0];
                int nextCol = now[1]+move[1];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || boxes[nextRow][nextCol] != 0) {
                    continue;
                }
                if (boxes[nextRow][nextCol] == 0 && dayCnts[nextRow][nextCol] == Integer.MAX_VALUE) {
                    dayCnts[nextRow][nextCol] = Math.min(dayCnts[now[0]][now[1]]+1, dayCnts[nextRow][nextCol]);
                    queue.add(new Integer[]{nextRow, nextCol});
                    answer = Math.max(dayCnts[nextRow][nextCol], answer);
                    total--;
                }
            }
        }
        return total != 0 ? -1 : answer;
    }
}
