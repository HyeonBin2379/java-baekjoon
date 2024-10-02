package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise30980 {

    private static char[][] testSheet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        testSheet = new char[3*n][8*m];
        for (int i = 0; i < testSheet.length; i++) {
            testSheet[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < testSheet.length; i += 3) {
            for (int j = 0; j < testSheet[0].length; j += 8) {
                int a = testSheet[i+1][j+1] - '0';
                int b = testSheet[i+1][j+3] - '0';
                int c = testSheet[i+1][j+5] - '0';
                int len = 5;

                if (testSheet[i+1][j+6] != '.') {
                    c *= 10;
                    c += testSheet[i+1][j+6]-'0';
                    len++;
                }

                if (a + b != c) {
                    testSheet[i+1][j+2] = '/';
                    testSheet[i][j+3] = testSheet[i+1][j+2];
                    testSheet[i+2][j+1] = testSheet[i][j+3];
                    continue;
                }
                testSheet[i+1][j+len+1] = testSheet[i+1][j] = '*';
                for (int k = 1; k <= len; k++) {
                    testSheet[i][j+k] = '*';
                    testSheet[i+2][j+k] = '*';
                }
            }
        }
        IntStream.rangeClosed(0, testSheet.length-1)
                .forEach(i -> System.out.println(new String(testSheet[i])));
    }
}
