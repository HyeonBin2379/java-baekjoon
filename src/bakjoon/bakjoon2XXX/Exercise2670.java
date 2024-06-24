package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        double[] num = new double[len+1];
        double[] dp = new double[len+1];
        double max = 0;
        for (int i = 1; i <= len; i++) {
            num[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(num[i], dp[i-1]*num[i]);
            max = Math.max(dp[i], max);
        }
        System.out.printf("%.3f\n", max);
    }
}
