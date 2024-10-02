package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise25165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        boolean[][] monster = new boolean[row + 1][col + 1];

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isRight = Integer.parseInt(st.nextToken()) == 1;
        int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        monster[pos[0]][pos[1]] = true;

        for (int i = 1; i <= row; i++) {
            int j = start;
            if (!isRight) {
                for (; j >= 1; j--) {
                    if (i == row && j == col && !monster[i][j]) {
                        System.out.println("YES!");
                        return;
                    } else if (monster[i][j]) {
                        System.out.println("NO...");
                        return;
                    }
                }
                isRight = true;
            } else {
                for (; j <= col; j++) {
                    if (i == row && j == col && !monster[i][j]) {
                        System.out.println("YES!");
                        return;
                    } else if (monster[i][j]) {
                        System.out.println("NO...");
                        return;
                    }
                }
                isRight = false;
            }
            start = isRight ? 1 : col;
        }
    }
}
