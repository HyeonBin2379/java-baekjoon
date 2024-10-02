package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise8387 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine().trim());
        char[] original = br.readLine().toCharArray();
        char[] dyslexia = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (original[i] == dyslexia[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
