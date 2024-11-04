package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0;
        for (int i = 0; i <= n-3; i++) {
            for (int j = i+3; j <= n; j++) {
                String temp = input.substring(i, j);
                long aCnt = temp.chars().filter(ch -> (char)ch == 'A').count();
                long nCnt = temp.chars().filter(ch -> (char)ch == 'N').count();
                if (temp.startsWith("A") && temp.endsWith("A") && aCnt == 2 && nCnt == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
