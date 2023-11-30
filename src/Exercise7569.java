import java.io.*;
import java.util.*;

public class Exercise7569 {
    private static int row, col, hei;
    private static int[][][] tomatoBox;
    private static final Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        hei = Integer.parseInt(st.nextToken());

        tomatoBox = new int[hei][row][col];
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < row; j++) {
                tomatoBox[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < col; k++) {
                    if (tomatoBox[i][j][k] == 1) {
                        queue.add(new Integer[]{i, j, k});
                    }
                }
            }
        }
        br.close();

        bfs();
        System.out.println(getResult());
    }

    public static void bfs() {
        Integer[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
        while (!queue.isEmpty()){
            Integer[] now = queue.poll();
            for (Integer[] direction : move) {
                Integer[] next = new Integer[3];
                for (int i = 0; i < 3; i++) {
                    next[i] = now[i] + direction[i];
                }

                if (isNotRange(next[0], next[1], next[2])) {
                    continue;
                }

                if (tomatoBox[next[0]][next[1]][next[2]] == 0) {
                    queue.offer(new Integer[]{next[0], next[1], next[2]});
                    tomatoBox[next[0]][next[1]][next[2]] = tomatoBox[now[0]][now[1]][now[2]] + 1;
                }
            }
        }
    }

    private static boolean isNotRange(int h, int r, int c) {
        return h < 0 || r < 0 || c < 0
                || h >= hei || r >= row || c >= col;
    }

    public static int getResult() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < row; j++) {
                if (checkZero(tomatoBox[i][j])) {
                    return -1;
                }
                max = Math.max(max, getRowMax(tomatoBox[i][j]));
            }
        }
        return max-1;
    }
    private static int getRowMax(int[] tomatoBoxRow) {
        return Arrays.stream(tomatoBoxRow).max().getAsInt();
    }
    private static boolean checkZero(int[] tomatoBoxRow) {
        return Arrays.stream(tomatoBoxRow)
                .anyMatch(value -> value == 0);
    }
}
