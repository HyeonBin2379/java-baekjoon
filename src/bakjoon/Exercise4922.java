package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int result = 1;
            for (int i = 1; i < n; i++) {
                result += 2*i;
            }
            sb.append(String.format("%d => %d\n", n, result));
        }
        System.out.print(sb);
    }
}
