package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = {"pi", "ka", "chu"};
        String input = br.readLine();
        int len = input.length();

        for (int i = 0; i < 3; i++) {
            while (input.contains(token[i])) {
                input = input.replaceFirst(token[i], "X".repeat(token[i].length()));
            }
        }
        System.out.println(input.equals("X".repeat(len)) ? "YES" : "NO");
    }
}
