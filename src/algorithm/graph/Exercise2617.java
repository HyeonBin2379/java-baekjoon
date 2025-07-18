package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] weight = new int[n+1][n+1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            weight[heavy][light] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (weight[i][k] == 1 && weight[k][j] == 1) {
                        weight[i][j] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int lighter = Arrays.stream(weight[i]).sum();
            int heavier = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && weight[j][i] == 1) {
                    heavier++;
                }
            }
            if (lighter > n/2 || heavier > n/2) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
