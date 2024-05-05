package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j <= n; j++) {
                int exp = 0;
                while (n % j == 0) {
                    n /= j;
                    exp++;
                }
                if (exp > 0) {
                    sb.append(String.format("%d %d\n", j, exp));
                }
            }
        }
        System.out.print(sb);
    }
}
