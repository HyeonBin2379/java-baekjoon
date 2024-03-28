package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] sum = new int[3];
            for (int j = 1; j <= n; j++) {
                sum[0] += j;
                sum[1] += (2*j-1);
                sum[2] += 2*j;
            }
            sb.append(num);
            for (int j = 0; j < 3; j++) {
                sb.append(" ").append(sum[j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
