package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] card = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (card[0][1] > 0 && card[1][1] > 0) {
            card[0][1] -= card[1][0];
            card[1][1] -= card[0][0];
        }

        if (card[0][1] > 0) {
            System.out.println("PLAYER A");
        } else if (card[1][1] > 0) {
            System.out.println("PLAYER B");
        } else {
            System.out.println("DRAW");
        }
    }
}
