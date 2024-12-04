package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int notSameLineCnt = 1;
        for (int i = 0; i < r; i++) {
            String word = br.readLine();
            if (word.length() == c) {
                System.out.println(word);
                continue;
            }
            int diff = c - word.length();
            int left, right;
            if (diff % 2 == 0) {
                left = right = diff/2;
            } else {
                if (notSameLineCnt % 2 == 1) {
                    left = diff/2;
                    right = diff/2+1;
                } else {
                    left = diff/2+1;
                    right = diff/2;
                }
                notSameLineCnt++;
            }
            System.out.println(".".repeat(left) + word + ".".repeat(right));
        }
    }
}
