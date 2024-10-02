package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2422 {

    private static final boolean[][] notRecommended = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            notRecommended[a][b] = true;
            notRecommended[b][a] = true;
        }

        int answer = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a+1; b <= n; b++) {
                if (notRecommended[a][b]) {
                    continue;
                }

                for (int c = b+1; c <= n; c++) {
                    if (notRecommended[b][c] || notRecommended[c][a]) {
                        continue;
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
