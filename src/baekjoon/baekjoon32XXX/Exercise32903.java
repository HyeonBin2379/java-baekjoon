package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];
        for (int i = 0; i < n; i++) {
            char letter = br.readLine().charAt(0);
            check[letter-'a'] = true;
        }
        for (int i = 0; i < check.length; i++) {
            if (i > 0 && i % 6 == 0) {
                System.out.println();
            }
            System.out.print(check[i] ? (char)('a'+i) : '.');
        }
    }
}
