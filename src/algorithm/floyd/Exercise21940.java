package algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise21940 {

    private static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] map = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long time = Long.parseLong(st.nextToken());
            map[from][to] = time;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] >= map[i][k]+map[k][j]) {
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] answer = new long[n+1];
        long min = INF;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                // 각각의 왕복시간의 최댓값 구하기
                int city = home[j];
                long dist = map[i][city]+map[city][i];
                if (answer[i] < dist) {
                    answer[i] = dist;
                }
            }
            // 구한 왕복시간의 최댓값들 중 최솟값 구하기
            min = Math.min(answer[i], min);
        }

        // 구한 최솟값을 갖는 도시의 번호 출력
        for (int i = 1; i <= n; i++) {
            if (answer[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
