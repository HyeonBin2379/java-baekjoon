package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5768 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }

            int maxCount = 0;
            int maxNum = 0;
            for (int i = m; i <= n; i++) {
                int count = 0;
                for (int j = 1; j*j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                        if (j != i/j) {
                            count++;
                        }
                    }
                }
                if (count >= maxCount) {
                    maxCount = count;
                    if (i > maxNum) {
                        maxNum = i;
                    }
                }
            }
            sb.append(maxNum).append(" ").append(maxCount).append("\n");
        }
        System.out.print(sb);
    }
}
