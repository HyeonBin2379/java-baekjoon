package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            char[] letter = input.toCharArray();
            for (char c : letter) {
                if (c == 'e') {
                    sb.append('i');
                } else if (c == 'i') {
                    sb.append('e');
                } else if (c == 'E') {
                    sb.append('I');
                } else if (c == 'I') {
                    sb.append('E');
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
