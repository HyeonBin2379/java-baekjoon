package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise9229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String before = br.readLine();
            if (before.equals("#")) {
                break;
            }

            String answer = "Correct\n";
            while (true) {
                String after = br.readLine();
                if (after.equals("#")) {
                    sb.append(answer);
                    break;
                }
                if (!isAble(before, after)) {
                    answer = "Incorrect\n";
                }
                before = after;
            }
        }
        System.out.print(sb);
    }

    private static boolean isAble(String before, String after) {
        if (before.equals(after) || before.length() != after.length()) {
            return false;
        }
        int count = (int) IntStream.rangeClosed(0, before.length()-1)
                .filter(i -> before.charAt(i) != after.charAt(i))
                .count();
        return count == 1;
    }
}
