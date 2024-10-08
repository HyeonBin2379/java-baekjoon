package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(input[i])) {
                input[i] = Character.toUpperCase(input[i]);
            } else {
                input[i] = Character.toLowerCase(input[i]);
            }
        }
        System.out.println(new String(input));
    }
}
