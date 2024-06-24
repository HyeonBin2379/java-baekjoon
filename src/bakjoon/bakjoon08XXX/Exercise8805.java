package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise8805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] strict = new int[n];
            if (n == 1) {
                sb.append(k).append("\n");
                continue;
            }

            boolean high = false;
            int index = 0;
            for (int j = 1; j <= k; j++) {
                if (index == 0) {
                    if (high) {
                        high = false;
                    }
                    strict[index++] += 1;
                } else if (index == n-1) {
                    if (!high) {
                        high = true;
                    }
                    strict[index--] += 1;
                } else {
                    if (high) {
                        strict[index--] += 1;
                    } else {
                        strict[index++] += 1;
                    }
                }
            }
            Arrays.stream(strict).forEach(value -> sb.append(value).append(" "));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
