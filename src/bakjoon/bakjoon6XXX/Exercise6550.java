package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            String[] words = input.split(" ");
            bw.write(isSubString(words[0], words[1]) ? "Yes\n" : "No\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isSubString(String src, String comp) {
        int idx = 0;
        for (int i = 0; i < comp.length(); i++) {
            if (src.charAt(idx) == comp.charAt(i)) {
                idx++;
            }
            if (idx == src.length()) {
                return true;
            }
        }
        return false;
    }
}
