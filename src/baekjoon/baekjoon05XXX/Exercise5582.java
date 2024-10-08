package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5582 {

    private static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        table = new int[str1.length()+1][str2.length()+1];
        LCS(str1, str2);
    }

    private static void LCS(String str1, String str2) {
        int answer = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = table[i-1][j-1]+1;
                }
                answer = Math.max(table[i][j], answer);
            }
        }
        System.out.println(answer);
    }
}
