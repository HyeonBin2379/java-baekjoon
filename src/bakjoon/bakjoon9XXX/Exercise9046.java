package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise9046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] alphabet = new int[26];
            char[] input = Arrays.stream(br.readLine().split(""))
                    .filter(s -> !s.equals(" "))
                    .collect(Collectors.joining())
                    .toCharArray();

            int max = Integer.MIN_VALUE;
            int answer = -1;
            for (char c : input) {
                int index = c - 'a';
                alphabet[index]++;
                if (max < alphabet[index]) {
                    max = alphabet[index];
                    answer = index;
                }
            }
            int finalMax = max;
            int count = (int) Arrays.stream(alphabet).filter(value -> value == finalMax).count();
            sb.append((count > 1) ? "?" : (char)('a'+answer)).append("\n");
        }
        System.out.print(sb);
    }
}
