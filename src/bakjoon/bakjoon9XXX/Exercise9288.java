package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(String.format("Case %d:\n", i));
            for (int j = 1; j <= num/2; j++) {
                if (j <= 6 && num-j <= 6) {
                    sb.append(String.format("(%d,%d)\n", j, num - j));
                }
            }
        }
        System.out.print(sb);
    }
}
