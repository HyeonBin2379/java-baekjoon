package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20528 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] word = br.readLine().split(" ");
        int answer = 1;
        for (int i = 1; i < n; i++) {
            int len1 = word[i-1].length();
            if (word[i - 1].charAt(len1 - 1) != word[i].charAt(0)) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
