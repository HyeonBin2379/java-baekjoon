package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        int[] table = makeTable(p);
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            while (idx > 0 && s.charAt(i) != p.charAt(idx)) {
                idx = table[idx-1];
            }
            if (s.charAt(i) == p.charAt(idx)) {
                if (idx == p.length()-1) {
                    System.out.println(1);
                    return;
                }
                idx++;
            }
        }
        System.out.println(0);
    }

    public static int[] makeTable(String p) {
        int len = p.length();
        int[] table = new int[len];
        int idx = 0;

        for (int i = 1; i < len; i++) {
            while (idx > 0 && p.charAt(i) != p.charAt(idx)) {
                idx = table[idx-1];
            }
            if (p.charAt(i) == p.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}
