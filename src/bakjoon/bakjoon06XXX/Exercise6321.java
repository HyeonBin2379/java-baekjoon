package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            String[] input = br.readLine().split("");
            sb.append(String.format("String #%d\n", i));
            for (String s : input) {
                char letter = (s.charAt(0) == 'Z') ? 'A' : (char) (s.charAt(0) + 1);
                sb.append(letter);
            }
            sb.append("\n\n");
        }
        System.out.print(sb);
    }
}
