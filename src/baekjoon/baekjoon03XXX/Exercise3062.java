package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String original = br.readLine();
            String reversed = new StringBuilder(original).reverse().toString();
            int[] digit = Arrays.stream(Integer.toString(Integer.parseInt(original) + Integer.parseInt(reversed)).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String answer = "YES";
            for (int j = 0; j < digit.length/2; j++) {
                if (digit[j] != digit[digit.length - 1 - j]) {
                    answer = "NO";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
