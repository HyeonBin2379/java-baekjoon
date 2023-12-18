package bakjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Exercise7576 {
    private static int row, col;
    private static int[][] tomatoBox;
    private static Queue<Integer[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        tomatoBox = new int[row][col];
        queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            tomatoBox[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                if (tomatoBox[i][j] == 1) {
                    queue.add(new Integer[]{i, j});
                }
            }
        }
        br.close();

        bfs();
        System.out.println(getResult());
    }

    public static void bfs() {
        Integer[][] move = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (Integer[] direction : move) {
                int x = now[0]+direction[0];
                int y = now[1]+direction[1];

                if (x < 0 || y < 0 || x >= row || y >= col || tomatoBox[x][y] != 0) {
                    continue;
                }

                if (tomatoBox[x][y] == 0) {
                    queue.add(new Integer[]{x, y});
                    tomatoBox[x][y] = tomatoBox[now[0]][now[1]] + 1;
                }
            }
        }
    }

    public static boolean checkZero(int[] tomatoBoxRow) {
        return Arrays.stream(tomatoBoxRow)
                .anyMatch(value -> value == 0);
    }
    public static int getResult() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            if (checkZero(tomatoBox[i])) {
                return -1;
            }
            for (int j = 0; j < col; j++) {
                max = Math.max(max, tomatoBox[i][j]);
            }
        }
        return max-1;
    }
}
