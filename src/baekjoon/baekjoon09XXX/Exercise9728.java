package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long sum = Integer.parseInt(st.nextToken());
            long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            int count = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (num[j]+num[k] == sum) {
                        count++;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, count));
        }
        System.out.print(sb);
    }
}
