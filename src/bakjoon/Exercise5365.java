package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(br.readLine());
        String[] msgToken = Arrays.stream(br.readLine().split(" ")).filter(s -> !s.isEmpty()).toArray(String[]::new);
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                sb.append(msgToken[i].charAt(0));
                continue;
            }

            int idx = msgToken[i-1].length();
            sb.append((idx > msgToken[i].length()) ? " " : msgToken[i].charAt(idx-1));
        }
        System.out.print(sb);
    }
}
