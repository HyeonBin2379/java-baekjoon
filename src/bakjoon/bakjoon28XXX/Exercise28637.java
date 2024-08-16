package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringBuilder sb = new StringBuilder();
            String input = br.readLine();
            for (char ch : input.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                }
                sb.append(Character.toLowerCase(ch));
            }
            System.out.println(sb);
        }
    }
}
