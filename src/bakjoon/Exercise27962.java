package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27962 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 1; i <= n; i++) {
            String subStr1 = input.substring(0, i);
            String subStr2 = input.substring(n-i);
            if (isVitamin(subStr1, subStr2, subStr1.length())) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean isVitamin(String str1, String str2, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
