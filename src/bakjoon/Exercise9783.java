package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        for (char c : input) {
            if (c >= 'a' && c <= 'z') {
                int num = c - 'a' + 1;
                sb.append(String.format("%02d", num));
            } else if (c >= 'A' && c <= 'Z') {
                int num = c - 'A' + 27;
                sb.append(num);
            } else if (Character.isDigit(c)) {
                sb.append(String.format("#%c", c));
            } else {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}
