package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9636 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] cmd = br.readLine().toCharArray();
            int x = 0, y = 0, q = 0;
            for (char c : cmd) {
                switch (c) {
                    case 'U' -> y++;
                    case 'R' -> x++;
                    case 'D' -> y--;
                    case 'L' -> x--;
                    case '?' -> q++;
                }
            }
            System.out.printf("%d %d %d %d\n", x-q, y-q, x+q, y+q);
        }
    }
}
