package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] isValid = new boolean[n+1][n+1];
        int[][] minDist = new int[n+1][n+1];    // 이미 최소 이동 시간을 구한 인접행렬
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(isValid[i], true);
            for (int j = 1; j <= n; j++) {
                minDist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 불필요한 간선: i->j일 때, 정점 k를 경유하는 이동거리와 직행할 때의 이동거리가 같으면 직행하는 간선 제거
                    if (minDist[i][j] == minDist[i][k]+minDist[k][j] && i != k && j != k) {
                        isValid[i][j] = false;
                    } else if (minDist[i][j] > minDist[i][k]+minDist[k][j]) {
                        // 구한 이동 시간이 최소가 아닌 경우
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isValid[i][j]) {
                    answer += minDist[i][j];
                }
            }
        }
        System.out.println(answer/2);
    }
}
