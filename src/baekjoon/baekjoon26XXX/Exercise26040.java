package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] letter = br.readLine().split(" ");
        for (String s : letter) {
            input = input.replace(s, s.toLowerCase());
        }
        System.out.println(input);
    }
}
