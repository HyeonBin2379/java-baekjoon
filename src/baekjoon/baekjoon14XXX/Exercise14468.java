package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14468 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[][] cowPath = new int[26][2];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            cowPath[ch-'A'][0] = input.indexOf(ch);
            cowPath[ch-'A'][1] = input.lastIndexOf(ch);
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    continue;
                }
                if (cowPath[i][0] < cowPath[j][0]
                        && cowPath[j][0] < cowPath[i][1]
                        && cowPath[i][1] < cowPath[j][1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
