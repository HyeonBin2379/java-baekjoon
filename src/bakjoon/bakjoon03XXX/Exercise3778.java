package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3778 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            String input1 = br.readLine();
            int[] letterCnt1 = new int[26];
            for (int j = 0; j < input1.length(); j++) {
                letterCnt1[input1.charAt(j)-'a']++;
            }

            String input2 = br.readLine();
            int[] letterCnt2 = new int[26];
            for (int j = 0; j < input2.length(); j++) {
                letterCnt2[input2.charAt(j)-'a']++;
            }

            int answer = 0;
            for (int j = 0; j < 26; j++) {
                answer += Math.abs(letterCnt1[j]-letterCnt2[j]);
            }
            sb.append(String.format("Case #%d: %d\n", i, answer));
        }
        System.out.print(sb);
    }
}
