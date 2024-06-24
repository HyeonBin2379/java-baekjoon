package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] orig = br.readLine().toCharArray();
        String key = br.readLine();

        int cycle = (int) Math.ceil((double)orig.length/key.length());
        char[] codeKey = key.repeat(cycle).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orig.length; i++) {
            if (orig[i] == ' ') {
                sb.append(orig[i]);
                continue;
            }

            int diff = codeKey[i]-'a'+1;
            if (orig[i] - diff < 'a') {
                char newChar = (char)(orig[i]-diff+26);
                sb.append(newChar);
            } else {
                sb.append((char)(orig[i]-diff));
            }
        }
        System.out.println(sb);
    }
}
