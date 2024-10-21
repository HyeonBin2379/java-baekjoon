package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2567 {

    private static final int PAPER_SIZE = 10;
    private static final int[][] map = new int[101][101];
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < x+PAPER_SIZE; i++) {
                for (int j = y; j < y+PAPER_SIZE; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (map[i][j] == 1) {
                    answer += countEmptySide(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static int countEmptySide(int x, int y) {
        int count = 0;
        for (int[] ints : move) {
            int nx = x + ints[0];
            int ny = y + ints[1];
            if (map[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }
}
