package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num1 = br.readLine();
        String num2 = br.readLine();

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 > len2) {
            num2 = "0".repeat(len1-len2) + num2;
        } else if (len1 < len2) {
            num1 = "0".repeat(len2-len1) + num1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int n1 = num1.charAt(i)-'0';
            int n2 = num2.charAt(i)-'0';
            if ((n1 < 3 && n2 < 3) || (n1 > 6 && n2 > 6)) {
                sb.append("0");
            } else {
                sb.append("9");
            }
        }
        System.out.println(sb);
    }
}
