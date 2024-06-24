package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] coefficient = new int[n+1];
            for (int j = 0; j < n; j++) {
                coefficient[j] = Integer.parseInt(st.nextToken());
            }

            int[] result = new int[n+1];
            result[0] = n-1;
            for (int j = 0; j < n; j++) {
                result[j+1] = (n-j)*coefficient[j];
            }
            sb.append(String.format("Case %d:", i));
            Arrays.stream(result).forEach(value -> sb.append(" ").append(value));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}