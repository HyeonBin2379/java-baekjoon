package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            graph[heavy][light] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        int mid = n /2;
        for (int i = 1; i <= n; i++) {
            int heavier = 0;
            int lighter = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) {
                    heavier++;
                } else if (graph[j][i]) {
                    lighter++;
                }
            }

            /* 현재 구슬보다 무게가 크거나 작은 구슬이 전체 구슬 개수의 절반보다 많으면
               이 구슬의 무게는 중앙값이 될 수 없다. */
            if (mid < heavier || mid < lighter) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
