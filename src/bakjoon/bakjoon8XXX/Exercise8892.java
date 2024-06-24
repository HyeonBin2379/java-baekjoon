package bakjoon.bakjoon8XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise8892 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for (int j = 0; j < n; j++) {
                str[j] = br.readLine();
            }

            Set<String> answer = new LinkedHashSet<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (isPalindrome(str[j]+str[k])) {
                        answer.add(str[j]+str[k]);
                        break;
                    }
                }
                if (!answer.isEmpty()) {
                    break;
                }
            }

            if (answer.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                answer.forEach(s -> sb.append(s).append("\n"));
            }
        }
        System.out.print(sb);
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
