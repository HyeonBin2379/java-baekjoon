package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int[] score = new int[n];
        for (int i = 0; i < m; i++) {
            int standard = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                if (cost[j] <= standard) {
                    score[j]++;
                    break;
                }
            }
        }

        int max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] > max) {
                max = score[i];
                ans = i;
            }
        }
        System.out.println(ans+1);
    }
}
