package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25643 {

    private static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        for (int i = 0; i < n-1; i++) {
            if (!canStack(i, m)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    private static boolean canStack(int bottom, int strLen) {
        for (int i = strLen; i >= 1; i--) {
            String prefix = str[bottom].substring(i-1, strLen);
            String postfix = str[bottom].substring(0, strLen+1-i);
            if (str[bottom+1].startsWith(prefix) || str[bottom+1].endsWith(postfix)) {
                return true;
            }
        }
        return false;
    }
}
