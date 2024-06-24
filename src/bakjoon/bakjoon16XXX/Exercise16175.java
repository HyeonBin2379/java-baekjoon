package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] votes = new long[m][n];
            for (int j = 0; j < m; j++) {
                votes[j] = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).toArray();
            }

            long[] totalSum = new long[n];
            long max = 0;
            int answer = -1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    totalSum[j] += votes[k][j];
                }
                if (max < totalSum[j]) {
                    max = totalSum[j];
                    answer = j+1;
                }
            }
            System.out.println(answer);
        }
    }
}
