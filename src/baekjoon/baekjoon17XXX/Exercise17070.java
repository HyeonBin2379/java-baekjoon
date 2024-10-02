package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise17070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // dp: 현재 칸이 마지막일 때, 가로, 대각선, 세로 방향으로 배치된 파이프 개수
        // i = 파이프 방향, j = 현재 행, k = 현재 열
        int[][][] dp = new int[3][n][n];

        // 첫번째 행 처리: 항상 가로 파이프만 사용
        dp[0][0][1] = 1;
        for (int i = 2; i < n; i++) {
            if (map[0][i] == 0) {
                dp[0][0][i] = dp[0][0][i-1];
            }
        }
        // 연결 규칙상 파이프의 끝은 첫번째 열에 도달할 수 없음
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < n; c++) {
                // 대각선 방향 파이프 추가
                if (map[r][c] == 0 && map[r-1][c] == 0 && map[r][c-1] == 0) {
                    dp[1][r][c] = dp[0][r-1][c-1] + dp[1][r-1][c-1] + dp[2][r-1][c-1];
                }
                // 가로, 세로 방향 파이프 추가
                if (map[r][c] == 0) {
                    dp[0][r][c] = dp[0][r][c-1] + dp[1][r][c-1];
                    dp[2][r][c] = dp[2][r-1][c] + dp[1][r-1][c];
                }
            }
        }
        // 최종 결과
        System.out.println(IntStream.rangeClosed(0, 2).map(i -> dp[i][n-1][n-1]).sum());
    }
}
