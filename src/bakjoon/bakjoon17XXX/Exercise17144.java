package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17144 {

    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int r, c;
    private static int totalDust;
    private static int[][] room, add;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int upperRow = Integer.MAX_VALUE;
        room = new int[r][c];
        for (int i = 0; i < r; i++) {
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < c; j++) {
                if (room[i][j] == -1) {
                    upperRow = Math.min(i, upperRow);
                } else {
                    totalDust += room[i][j];
                }
            }
        }

        add = new int[r][c];
        while (t-- > 0) {
            spreadDust();
            airClean(upperRow);
        }
        System.out.println(totalDust);
    }

    private static void spreadDust() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                spread(i, j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                room[i][j] += add[i][j];
                add[i][j] = 0;
            }
        }
    }
    private static void spread(int row, int col) {
        int spreadCnt = 0;
        int value = room[row][col]/5;

        if (room[row][col] <= 0) {
            return;
        }
        for (int[] ints : move) {
            int nr = row + ints[0];
            int nc = col + ints[1];
            if (nr < 0 || nr >= r || nc < 0 || nc >= c || room[nr][nc] == -1) {
                continue;
            }
            add[nr][nc] += value;
            spreadCnt++;
        }
        add[row][col] -= (spreadCnt*value);
    }

    private static void airClean(int upperRow) {
        int lowerRow = upperRow+1;
        totalDust -= room[upperRow-1][0];
        totalDust -= room[lowerRow+1][0];

        // 윗공기 순환
        for (int i = upperRow-1; i > 0; i--) {  // 왼쪽
            room[i][0] = room[i-1][0];
        }
        for (int i = 0; i < c-1; i++) { // 위
            room[0][i] = room[0][i+1];
        }
        for (int i = 1; i <= upperRow; i++) {   // 오른쪽
            room[i-1][c-1] = room[i][c-1];
        }
        for (int i = c-1; i > 1; i--) { // 아래
            room[upperRow][i] = room[upperRow][i-1];
        }
        room[upperRow][1] = 0;

        // 아랫공기 순환
        for (int i = lowerRow+1; i < r-1; i++) {    // 왼쪽
            room[i][0] = room[i+1][0];
        }
        for (int i = 0; i < c-1; i++) { // 아래
            room[r-1][i] = room[r-1][i+1];
        }
        for (int i = r-1; i >= lowerRow; i--) { // 오른쪽
            room[i][c-1] = room[i-1][c-1];
        }
        for (int i = c-1; i > 1; i--) { // 위
            room[lowerRow][i] = room[lowerRow][i-1];
        }
        room[lowerRow][1] = 0;
    }
}
