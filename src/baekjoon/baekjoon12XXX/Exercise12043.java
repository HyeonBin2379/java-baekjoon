package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise12043 {

    private static final long MOD = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testcase; t++) {
            String str = reader.readLine();
            long ans = 1;

            for (int i = 0; i < str.length(); i++) {
                Set<Character> uniqueChars = new HashSet<>();
                if (i > 0) {
                    uniqueChars.add(str.charAt(i - 1)); // 이전 글자 추가
                }
                uniqueChars.add(str.charAt(i)); // 현재 글자 추가
                if (i+1 < str.length()) {
                    uniqueChars.add(str.charAt(i + 1)); // 다음 글자 추가
                }
                ans = (ans * uniqueChars.size()) % MOD; // 가능한 글자의 수를 곱함
            }

            System.out.printf("Case #%d: %d%n", t, ans);
        }
    }
}
