package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] len = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                len[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int P = Integer.parseInt(st.nextToken());

        if (len[0][0] > P || len[1][0] > P) {
            System.out.println("No");
        } else if (len[0][0] + len[1][0] <= P) {
            System.out.println("Yes");
        } else if (len[0][1] >= len[1][0]) {
            System.out.println("Yes");
        } else if (len[1][1] >= len[0][0]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
