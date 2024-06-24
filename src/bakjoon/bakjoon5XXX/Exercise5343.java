package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int error = 0;
            for (int j = 7; j < input.length(); j += 8) {
                int count = (int) input.substring(j-7, j).chars().filter(value -> value == '1').count();
                int parity = count % 2;
                error += (parity == Integer.parseInt(String.valueOf(input.charAt(j)))) ? 0 : 1;
            }
            sb.append(error).append("\n");
        }
        System.out.print(sb);
    }
}
