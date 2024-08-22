package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise8436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        long totalCase = 1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'L' || ch == 'F' || ch == 'D' || ch == 'T') {
                totalCase <<= 1;
            }
        }
        System.out.println(totalCase);
    }
}
