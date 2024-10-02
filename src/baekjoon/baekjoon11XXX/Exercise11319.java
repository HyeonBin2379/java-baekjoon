package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise11319 {

    private static final String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            String[] input = br.readLine().toLowerCase().split("");
            int v = 0, total = input.length;
            for (String value : input) {
                if (value.equals(" ")) {
                    total--;
                } else if (vowels.contains(value)) {
                    v++;
                }
            }
            System.out.println((total-v) + " " + v);
        }
    }
}
