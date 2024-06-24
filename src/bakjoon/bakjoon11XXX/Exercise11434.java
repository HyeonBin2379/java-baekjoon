package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11434 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = 0; j < n; j++) {
                int[] prefer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                sum += Math.max(prefer[0]*w+prefer[2]*e, prefer[1]*w+prefer[3]*e);
            }
            sb.append(String.format("Data Set %d:\n%d\n\n", i, sum));
        }
        System.out.print(sb);
    }
}
