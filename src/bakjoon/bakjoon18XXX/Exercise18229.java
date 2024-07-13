package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] stretch = new int[m][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                stretch[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] person = new int[n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                person[j-1] += stretch[i-1][j-1];
                if (person[j-1] >= k) {
                    System.out.println(j + " " + i);
                    return;
                }
            }
        }
    }
}
