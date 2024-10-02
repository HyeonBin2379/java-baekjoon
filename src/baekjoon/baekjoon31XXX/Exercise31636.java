package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31636 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == 'o') {
                count++;
                if (count == 3) {
                    System.out.println("Yes");
                    return;
                }
            } else {
                count = 0;
            }
        }
        System.out.println("No");
    }
}
