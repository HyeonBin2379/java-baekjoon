package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise7600 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine().toLowerCase();
            if (input.equals("#")) {
                break;
            }
            int[] alphabet = new int[26];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    alphabet[input.charAt(i) - 'a']++;
                }
            }
            System.out.println(Arrays.stream(alphabet).filter(value -> value > 0).count());
        }
    }
}
