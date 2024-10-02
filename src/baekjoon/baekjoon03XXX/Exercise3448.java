package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int totalCnt = 0;
            int recognized = 0;
            while (true) {
                String input = br.readLine();
                if (input.isEmpty()) {
                    break;
                }
                totalCnt += input.length();
                recognized += input.chars().filter(value -> (char)value != '#').count();
            }

            double result = Math.round(((double) recognized*100/totalCnt) * 10) / 10.0;
            if (result % 1 == 0) {
                sb.append(String.format("Efficiency ratio is %d%%.\n", (int) result));
            } else {
                sb.append(String.format("Efficiency ratio is %.1f%%.\n", result));
            }
        }
        System.out.print(sb);
    }
}
