package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12317 {

    private static final String vowel = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            int result = calculate(word, n);
            sb.append(String.format("Case #%d: %d\n", i, result));
        }
        System.out.print(sb);
    }

    private static int calculate(String word, int n) {
        int len = word.length();
        int count = 0;

        for (int i = 0; i <= len-n; i++) {
            for (int j = i+n; j <= len; j++) {
                if (hasNConsecutive(word.substring(i, j), n)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean hasNConsecutive(String word, int n) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (vowel.indexOf(c) == -1) {
                count++;
                if (count >= n) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
