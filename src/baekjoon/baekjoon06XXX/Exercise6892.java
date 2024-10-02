package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6892 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] words = new String[3];
            for (int j = 0; j < 3; j++) {
                words[j] = br.readLine();
            }
            if (hasPrefix(words)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean hasPrefix(String[] words) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (words[i].startsWith(words[j])
                        || words[i].endsWith(words[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
