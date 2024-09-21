package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1491 {

    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] visited = new boolean[n][m];
        int row = 0, col = 0;
        int direction = 0;
        for (int i = 1; i < m*n; i++) {
            visited[row][col] = true;
            // 다음 위치 계산
            int nr = row + move[direction][0];
            int nc = col + move[direction][1];

            // 방향 전환
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) {
                direction = (direction+1) % 4;
                nr = row + move[direction][0];
                nc = col + move[direction][1];
            }

            // 다음 위치로 이동
            row = nr;
            col = nc;
        }
        // 마지막 위치 출력
        System.out.println(row + " " + col);
    }
}
