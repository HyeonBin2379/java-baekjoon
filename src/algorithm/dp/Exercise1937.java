package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1937 {

    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n;
    private static int[][] bambooForest, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bambooForest = new int[n][n];  // 대나무 숲
        dp = new int[n][n];     // (i, j)칸에서 출발했을 때의 최대 이동 칸수

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            bambooForest[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 판다의 이동 칸수의 최댓값을 구하기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(getDistance(i, j), answer);
            }
        }
        System.out.println(answer);
    }

    private static int getDistance(int r, int c) {
        if (dp[r][c] != -1) {   // 중복 계산 방지
            return dp[r][c];
        }
        dp[r][c] = 1;   // 배열 dp의 각 칸의 초기값
        for (int[] next : moves) {  // 다음 방문 순서: 현재 칸의 상하좌우칸
            int nr = r + next[0];
            int nc = c + next[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                continue;
            }
            if (bambooForest[r][c] < bambooForest[nr][nc]) {
                // top-down 방식: 처음 시작점에서 더 이상 방문할 지점이 없을 때까지 방문
                // dp의 각 칸에는 이동 거리의 최댓값을 저장
                dp[r][c] = Math.max(getDistance(nr, nc)+1, dp[r][c]);
            }
        }
        return dp[r][c];
    }
}
