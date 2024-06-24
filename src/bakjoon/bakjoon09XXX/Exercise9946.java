package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            String input1 = br.readLine();
            String input2 = br.readLine();
            if (input1.equals("END") && input2.equals(input1)) {
                break;
            }
            int[] alpha1 = getCount(input1);
            int[] alpha2 = getCount(input2);

            sb.append(String.format("Case %d: ", ++count));
            if (Arrays.equals(alpha1, alpha2)) {
                sb.append("same\n");
            } else {
                sb.append("different\n");
            }
        }
        System.out.print(sb);
    }

    private static int[] getCount(String str) {
        int[] alphabets = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alphabets[str.charAt(i) - 'a']++;
        }
        return alphabets;
    }
}
