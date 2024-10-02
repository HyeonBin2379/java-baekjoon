package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String imo = br.readLine();
        int count = imo.length();
        for (int i = 0; i < imo.length(); i++) {
            if (imo.charAt(i) == ':') {
                count++;
            }
            if (imo.charAt(i) == '_') {
                count += 5;
            }
        }
        System.out.println(count);
    }
}
