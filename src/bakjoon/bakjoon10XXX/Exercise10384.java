package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10384 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int[] alphabet = getCount(br.readLine().toLowerCase().toCharArray());
            int min = Arrays.stream(alphabet).min().getAsInt();
            sb.append(String.format("Case %d: ", i));
            switch (min) {
                case 0 -> sb.append("Not a pangram\n");
                case 1 -> sb.append("Pangram!\n");
                case 2 -> sb.append("Double pangram!!\n");
                case 3 -> sb.append("Triple pangram!!!\n");
            }
        }
        System.out.print(sb);
    }

    private static int[] getCount(char[] input) {
        int[] count = new int[26];
        for (char c : input) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        return count;
    }
}
