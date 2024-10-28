package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12518 {

    private static final String VOWELS_LOWER = "aeiou";
    private static final String VOWELS_UPPER = "AEIOU";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            String name = br.readLine().trim();
            char lastLetter = name.charAt(name.length()-1);
            if (VOWELS_LOWER.contains(String.valueOf(lastLetter))
                    || VOWELS_UPPER.contains(String.valueOf(lastLetter))) {
                sb.append(String.format("Case #%d: %s is ruled by a queen.\n", i, name));
            } else if (lastLetter == 'y' || lastLetter == 'Y') {
                sb.append(String.format("Case #%d: %s is ruled by nobody.\n", i, name));
            } else {
                sb.append(String.format("Case #%d: %s is ruled by a king.\n", i, name));
            }
        }
        System.out.print(sb);
    }
}
