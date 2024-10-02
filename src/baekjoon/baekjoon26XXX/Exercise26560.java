package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26560 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if (!input.endsWith(".")) {
                input += ".";
            }
            sb.append(input).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
