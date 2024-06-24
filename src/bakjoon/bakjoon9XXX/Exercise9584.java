package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise9584 {

    private static String pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pattern = br.readLine();
        int n = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String code = br.readLine();
            if (hasPattern(code)) {
                answer.add(code);
            }
        }
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static boolean hasPattern(String code) {
        for (int i = 0; i < 9; i++) {
            if (pattern.charAt(i) != '*'
                    && code.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
