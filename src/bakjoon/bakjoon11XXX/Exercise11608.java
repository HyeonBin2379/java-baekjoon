package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int[] alphabet = new int[26];
        for (char ch : input) {
            alphabet[ch-'a']++;
        }
        System.out.println(Arrays.stream(alphabet)
                .sorted()
                .limit(24)
                .sum());
    }
}
