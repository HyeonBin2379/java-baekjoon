package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int num = n, now = 1;
            while (n - now > 0) {
                n -= now;
                now++;
            }

            int temp1 = now - n + 1;
            int temp2 = n;
            if (now % 2 == 0) {
                int t = temp1;
                temp1 = temp2;
                temp2 = t;
            }
            sb.append(String.format("TERM %d IS %d/%d\n", num, temp1, temp2));
        }
        System.out.print(sb);
    }
}
