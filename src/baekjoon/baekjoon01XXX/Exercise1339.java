package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Exercise1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] digit = new Integer[26];
        Arrays.fill(digit, 0);
        while (n-- > 0) {
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                digit[ch-'A'] += (int)Math.pow(10, input.length()-1-i);
            }
        }
        Arrays.sort(digit, Comparator.reverseOrder());
        System.out.println(IntStream.rangeClosed(0, 9).map(i -> digit[i]*(9-i)).sum());
    }
}
