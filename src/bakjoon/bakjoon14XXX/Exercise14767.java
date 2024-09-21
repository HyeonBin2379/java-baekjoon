package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise14767 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] p = new int[n][m];
        for (int i = 0; i < n; i++) {
            p[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dp = new int[m];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] = (dp[j] > result[i]) ? dp[j]+p[i][j] : result[i]+p[i][j];
                result[i] = dp[j];
            }
        }
        System.out.println(Arrays.stream(result).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
