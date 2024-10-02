package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27333 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) == Character.toLowerCase(s.charAt(i))) {
                s = s.replaceFirst(s.substring(i, i+2), s.substring(i, i+2).toUpperCase());
            }
        }
        System.out.println(s);
    }
}
