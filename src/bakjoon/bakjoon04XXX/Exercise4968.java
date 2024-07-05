package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise4968 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            int[] taro = new int[n];
            int[] hanako = new int[m];
            int taroSum = 0, hanakoSum = 0;
            for (int i = 0; i < n+m; i++) {
                if (i < n) {
                    taro[i] = Integer.parseInt(br.readLine());
                    taroSum += taro[i];
                } else {
                    hanako[i-n] = Integer.parseInt(br.readLine());
                    hanakoSum += hanako[i-n];
                }
            }
            Arrays.sort(taro);
            Arrays.sort(hanako);

            String answer = "-1";
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int newSum1 = taroSum - taro[i] + hanako[j];
                    int newSum2 = hanakoSum - hanako[j] + taro[i];
                    if (newSum1 == newSum2) {
                        if (minSum > taro[i] + hanako[j]) {
                            minSum = taro[i] + hanako[j];
                            answer = String.format("%d %d", taro[i], hanako[j]);
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
