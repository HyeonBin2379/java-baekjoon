package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] cLang = new long[n];
            long cSum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cLang[j] = Long.parseLong(st.nextToken());
                cSum += cLang[j];
            }

            long eSum = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (cSum > cLang[j]*n && eSum < cLang[j]*m) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
