package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] array = new int[len+1];
        int[] dp = new int[len+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < len+1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dp[1] = array[1];
        for (int i = 1; i < len+1; i++) {
            dp[i] = array[i];
            for (int j = 1; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[j] + array[i], dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[len]);
    }
}
