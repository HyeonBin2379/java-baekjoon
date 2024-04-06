package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int[][] stepCnt = new int[m][n];
            for (int j = 0; j < m; j++) {
                stepCnt[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[] maxStep = new int[n];
            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (maxStep[j] < stepCnt[k][j]) {
                        maxStep[j] = stepCnt[k][j];
                    }
                }

                if (stepCnt[p-1][j] < maxStep[j]) {
                    answer += maxStep[j]-stepCnt[p-1][j];
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, answer));
        }
        System.out.print(sb);
    }
}
