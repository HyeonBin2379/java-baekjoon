package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5356 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            char letter = st.nextToken().charAt(0);
            makeLetterTriangle(line, letter);
        }
        System.out.print(sb);
    }

    public static void makeLetterTriangle(int line, char next) {
        for (int i = 1; i <= line; i++) {
            String letter = String.valueOf(next);
            sb.append(letter.repeat(i)).append("\n");
            next = (next == 'Z') ? 'A' : (char) (next + 1);
        }
        sb.append("\n");
    }
}
