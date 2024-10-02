package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] weights = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                weights[i][j] = Integer.parseInt(tokens[j-1]);
            }
        }

        int[][] store = new int[m+1][n+1];
        int[][] print = new int[m+1][n+1];
        int answer = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                for (int k = -1; k <= 1; k++) {
                    if (i+k < 1 || i+k > m) {
                        continue;
                    }
                    store[i][j] = Math.max(print[i+k][j-1], store[i][j]);
                }
                print[i][j] = store[i][j] + weights[i][j];
                answer = Math.max(store[i][j], answer);
            }
        }
        System.out.println(answer);
    }
}
